package com.jannsen.javavuepdf.controller;


import com.jannsen.javavuepdf.utils.PdfUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * pdf生成入口
 * 在大多数情况下pdf都是通过定时任务生成的 这里只是一个例子 挪一挪改一改就可以用了
 */
@RestController
@RequestMapping("/pdfDownload")
public class PdfDownloadController {

    private static final String NUXT_BASE_URL = "http://localhost:3000";//nuxt-pdf-template服务器地址

    private static final String FONT_PATH = "/home/fonts";//在linux或unix中itext没有使用文件流读字体 读不到jar包中的资源 这时候需要将字体挪到外部进行加载  在windows中直接读取resources下的无需修改


    @ResponseBody
    @RequestMapping(value = "/module1Page1/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module1Page1(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create(NUXT_BASE_URL, FONT_PATH, "/module1/page1/" + id, "module1-page1.pdf", response);
    }

    @ResponseBody
    @RequestMapping(value = "/module1Page2/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module1Page2(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create(NUXT_BASE_URL, FONT_PATH, "/module1/page2/" + id, "module1-page2.pdf", response);
    }

    @ResponseBody
    @RequestMapping(value = "/module2Page1/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module2Page1(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create(NUXT_BASE_URL, FONT_PATH, "/module2/page1/" + id, "module2-page1.pdf", response);
    }

    @ResponseBody
    @RequestMapping(value = "/module2Page2/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module2Page2(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create(NUXT_BASE_URL, FONT_PATH, "/module2/page2/" + id, "module2-page2.pdf", response);
    }

}

