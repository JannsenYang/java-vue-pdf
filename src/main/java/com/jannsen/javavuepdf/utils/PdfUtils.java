package com.jannsen.javavuepdf.utils;

import com.google.common.collect.Lists;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将html转换成pdf
 *
 * @author JannsenYang@outlook.com on 2018/11/10.
 */
public class PdfUtils {

    private static final String BEGIN_TAG = "<div id=\"begin\"></div>";//pdf-template/layouts/default.vue中 <nuxt/>标签的前
    private static final String END_TAG = "<div id=\"end\"></div>";//pdf-template/layouts/default.vue中 <nuxt/>标签的后

    private static final String STYLE_STYLE = "<style[^>]*>([^<]*)</style>"; //匹配style中的内容 截取到第一个</style>
    private static final String BODY_REGEX = "<body[^>]*>([\\s\\S]*)</body>"; //匹配body中的内容 截取到最后一个</body>

    private static final String NEED_END_TAG_REGEX = "<%s*[^>]+>"; //匹配标签%s中的内容 截取倒第一个>

    private static final List<String> NEED_END_TAG_LIST = Lists.newArrayList("img", "br", "hr", "input"); //需要闭合的标签


    private static final List<String> FONT_LIST = Lists.newArrayList("SourceHanSansCN-Light.ttf", "SourceHanSansCN-Normal.ttf", "SourceHanSansCN-Bold.ttf");

    private static ConverterProperties converterProperties;


    public static ResponseEntity<InputStreamResource> create(String baseUrl, String fontPath, String path, String fileName, HttpServletResponse response) {
        try {
            String html = HttpClientUtils.get(baseUrl + path);
            html = transform(baseUrl, html);
            File pdfFile = File.createTempFile("pdf", ".pdf");
            if (converterProperties == null) {
                converterProperties = new ConverterProperties();
                DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
                String basePath = ResourceUtils.CLASSPATH_URL_PREFIX;
                String os = System.getProperty("os.name");
                if (os.toLowerCase().contains("linux") || os.toLowerCase().contains("mac")) {
                    basePath = fontPath + "/";
                }
                for (String font : FONT_LIST) {
                    defaultFontProvider.addFont(FontProgramFactory.createFont(ResourceUtils.getFile(basePath + font).getPath()));
                }
                converterProperties.setFontProvider(defaultFontProvider);
            }
            Document document = HtmlConverter.convertToDocument(html, new PdfWriter(pdfFile), converterProperties);
            //do something
            document.close();

            InputStream inputStream = new FileInputStream(pdfFile.getAbsoluteFile());

            response.setDateHeader("Last-Modified", new Date().getTime());
            response.setDateHeader("Expires", -1);
            response.setHeader("Pragma", "Pragma");
            response.setHeader("Cache-Control", "public");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            return ResponseEntity.ok().body(new InputStreamResource(inputStream));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 过滤html中不需要的标签 纠正闭合的标签
     * 因itext解析使用的xml解析 所有标签必须闭合
     *
     * @param html
     * @return
     */
    private static String transform(String baseUrl, String html) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\"></meta>");

        //将样式抽离出来放在一个标签中
        sb.append("<style type=\"text/css\">");
        Matcher styleMatcher = Pattern.compile(STYLE_STYLE, Pattern.CASE_INSENSITIVE).matcher(html);
        while (styleMatcher.find()) {
            sb.append(styleMatcher.group(1));
        }
        sb.append("</style>");

        sb.append("</head>");

        //将body中的数据抽离出来
        sb.append("<body>");
        Matcher bodyMatcher = Pattern.compile(BODY_REGEX, Pattern.CASE_INSENSITIVE).matcher(html);
        if (bodyMatcher.find()) {
            String body = bodyMatcher.group(1);
            int beginIndex = body.indexOf(BEGIN_TAG);
            int endIndex = body.indexOf(END_TAG);
            if (beginIndex < 0 || endIndex < 0) {
                throw new RuntimeException("not found begin or end tag");
            }
            body = body.substring(beginIndex + BEGIN_TAG.length(), endIndex);

            //因itext解析html时完全遵循xml解析方式 所有的标签必须要闭合 而html中有许多标签不需要闭合 所以需要手动加上闭合标签
            for (String needEndTag : NEED_END_TAG_LIST) {
                Matcher needEndMatcher = Pattern.compile(String.format(NEED_END_TAG_REGEX, needEndTag), Pattern.CASE_INSENSITIVE).matcher(body);
                int endTagLength = 0;
                while (needEndMatcher.find()) {
                    int end = needEndMatcher.end() + endTagLength;
                    int beforeClose = end - 1;
                    boolean need = true;
                    while (beforeClose-- >= 0) {
                        String value = body.substring(beforeClose, beforeClose + 1).trim();
                        if (!StringUtils.isEmpty(value)) {
                            if ("/".equals(value)) {
                                need = false;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                    if (!need) {
                        continue;
                    }
                    body = body.substring(0, end - 1) + "/>" + body.substring(end, body.length());
                    endTagLength++;
                }
            }
            sb.append(body);
        }

        sb.append("</body>");
        sb.append("</html>");

        //将html中图片资源的url改为绝对路径
        html = sb.toString().replaceAll("<!---->", "").replaceAll("src=\"/_nuxt/", "src=\"" + baseUrl + "/_nuxt/");
        return html;
    }

}
