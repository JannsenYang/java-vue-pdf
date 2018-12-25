package com.jannsen.javavuepdf.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * http方法
 *
 * @author JannsenYang@outlook.com on 2016/11/9.
 */
public class HttpClientUtils {

    static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static final String CHARSET = "UTF-8";
    private final static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;
    private static CloseableHttpClient httpClient;

    static {
        poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(200);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(20);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(5000).setSocketTimeout(15000).build();
        try {
            SSLContextBuilder builder = SSLContexts.custom();
            builder.loadTrustMaterial(null, (chain, authType) -> true);
            SSLContext sslContext = builder.build();
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                    sslContext, (value, sslSession) -> true);
            httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).setConnectionManager(poolingHttpClientConnectionManager).setConnectionManagerShared(true).setSSLSocketFactory(sslConnectionSocketFactory).build();
        } catch (Exception e) {
            if (httpClient == null) {
                httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).setConnectionManager(poolingHttpClientConnectionManager).setConnectionManagerShared(true).build();
            }
        }
    }

    public static String post(String url) {
        HttpPost http = new HttpPost(url);

        http.setHeader("accept", "*/*");
        http.setHeader("connection", "Keep-Alive");
        http.setHeader("user-web", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        http.setHeader("Content-type", ContentType.APPLICATION_JSON.toString());
        return call(http);
    }

    public static <T> T post(String url, Class<T> clazz) {
        String responseJson = post(url);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseObject(responseJson, clazz);
    }

    public static String post(String url, List<NameValuePair> nameValuePairs) {
        HttpPost http = new HttpPost(url);
        try {
            http.setEntity(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return call(http);
    }


    public static <T> T post(String url, List<NameValuePair> nameValuePairs, Class<T> clazz) {
        String responseJson = post(url, nameValuePairs);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseObject(responseJson, clazz);
    }

    public static String shortPost(String url, List<NameValuePair> nameValuePairs) {
        HttpPost http = new HttpPost(url);
        try {
            http.setEntity(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return shortCall(http);
    }

    public static <T> T postForm(String url, Map<String, String> paramMap, Class<T> clazz) {
        HttpPost http = new HttpPost(url);
        http.setHeader("accept", "*/*");
        http.setHeader("connection", "Keep-Alive");
        http.setHeader("user-web", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        http.setHeader("Content-type", "application/x-www-form-urlencoded");
        try {
            List<NameValuePair> nameValuePairs = Lists.newArrayList();
            paramMap.forEach((key, value) -> nameValuePairs.add(new BasicNameValuePair(key, value)));

            http.setEntity(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String response = shortCall(http);
        return JSON.parseObject(response, clazz);
    }

    private static String shortCall(HttpRequestBase request) {
        CloseableHttpClient shortHttpClient = HttpClients.createDefault();
        try (CloseableHttpResponse response = shortHttpClient.execute(request)) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                return CharStreams.toString(new BufferedReader(new InputStreamReader(responseEntity.getContent(), CHARSET)));
            } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                HttpEntity responseEntity = response.getEntity();
                String errorResponse = CharStreams.toString(new BufferedReader(new InputStreamReader(responseEntity.getContent(), CHARSET)));
                if (!StringUtils.isEmpty(errorResponse)) {
                    logger.error("<br/> http请求错误：URI ==> " + request.getURI() + "<br/> ERROR ==> " + errorResponse + "<br/>");
                    throw new RuntimeException("http请求错误:" + errorResponse);
                }
            }
            if (response.getEntity() != null) {
                String errorMessage = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), CHARSET)).readLine();
                logger.error("<br/> 接收数据错误：URI ==> " + request.getURI() + "<br/> ERROR ==> " + errorMessage + "<br/>");
                throw new RuntimeException("<br/> 接收数据错误：URI ==> " + request.getURI() + "<br/> ERROR ==> " + errorMessage + "<br/>");
            }
            throw new RuntimeException("<br/> 接收数据错误！URI ==> " + request.getURI() + "<br/>");
        } catch (IOException e) {
            logger.error("IO 异常，错误信息：{}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            request.releaseConnection();
        }
    }

    public static <T> List<T> postList(String url, List<NameValuePair> nameValuePairs, Class<T> clazz) {
        String responseJson = post(url, nameValuePairs);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseArray(responseJson, clazz);
    }

    public static <T> List<T> postList(String url, String json, Class<T> clazz) {
        String responseJson = post(url, json);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseArray(responseJson, clazz);
    }

    public static String post(String url, String json) {
        HttpPost http = new HttpPost(url);
        http.setHeader("accept", "application/json");
        http.setHeader("connection", "Keep-Alive");
        http.setHeader("user-web", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        http.setHeader("Content-type", ContentType.APPLICATION_JSON.toString());
        if (!StringUtils.isEmpty(json)) {
            StringEntity strEntity = new StringEntity(json, Charset.forName(CHARSET));
            strEntity.setContentType("application/json");
            http.setEntity(strEntity);
        }
        return call(http);
    }

    public static <T> T post(String url, String json, Class<T> clazz) {
        String responseJson = post(url, json);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseObject(responseJson, clazz);
    }

    public static String post(String url, HttpEntity httpEntity) {
        HttpPost http = new HttpPost(url);
        http.setEntity(httpEntity);
        return call(http);
    }

    public static String post(String url, byte[] data, int length) {
        HttpPost http = new HttpPost(url);
        if (length > 0) {
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(data, 0, length, ContentType.APPLICATION_FORM_URLENCODED);
            http.setEntity(byteArrayEntity);
        }

        http.setHeader("accept", "*/*");
        http.setHeader("connection", "Keep-Alive");
        http.setHeader("user-web", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        http.setHeader("Content-type", "application/x-www-form-urlencoded");
        return call(http);
    }

    public static <T> T post(String url, byte[] data, int length, Class<T> clazz) {
        String responseJson = post(url, data, length);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseObject(responseJson, clazz);
    }

    public static String get(String url) {
        HttpGet http = new HttpGet(url);
        http.setHeader("accept", "application/json");
        http.setHeader("connection", "Keep-Alive");
        http.setHeader("user-web", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        http.setHeader("Content-type", ContentType.APPLICATION_JSON.toString());
        return call(http);
    }

    public static <T> T get(String url, Class<T> clazz) {
        String responseJson = get(url);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseObject(responseJson, clazz);
    }

    public static <T> List<T> getList(String url, Class<T> clazz) {
        String responseJson = get(url);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseArray(responseJson, clazz);
    }

    public static String delete(String url) {
        HttpDelete http = new HttpDelete(url);

        http.setHeader("accept", "*/*");
        http.setHeader("connection", "Keep-Alive");
        http.setHeader("user-web", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        http.setHeader("Content-type", ContentType.DEFAULT_TEXT.toString());
        return call(http);
    }

    public static <T> T delete(String url, Class<T> clazz) {
        String responseJson = delete(url);
        if (StringUtils.isEmpty(responseJson)) {
            return null;
        }
        return JSON.parseObject(responseJson, clazz);
    }

    private static String call(HttpRequestBase request) {
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                return CharStreams.toString(new BufferedReader(new InputStreamReader(responseEntity.getContent(), CHARSET)));
            } else if (response.getStatusLine().getStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                HttpEntity responseEntity = response.getEntity();
                String errorResponse = CharStreams.toString(new BufferedReader(new InputStreamReader(responseEntity.getContent(), CHARSET)));
                if (!StringUtils.isEmpty(errorResponse)) {
                    logger.error("<br/> http请求错误：URI ==> " + request.getURI() + "<br/>  ERROR ==> " + errorResponse + "<br/>");
                    throw new RuntimeException("http请求错误:" + errorResponse);
                }
            }
            if (response.getEntity() != null) {
                StringBuilder errorMessage = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), CHARSET));
                while (!StringUtils.isEmpty(reader.readLine())) {
                    errorMessage.append(reader.readLine()).append("\r\n");
                }
                if (!StringUtils.isEmpty(errorMessage.toString())) {
                    logger.error("\r\n 接收数据错误：URI ==> " + request.getURI() + "\r\n ERROR ==> " + errorMessage.toString() + "\r\n");
                    throw new RuntimeException("\r\n 接收数据错误：URI ==> " + request.getURI() + "\r\n ERROR ==> " + errorMessage.toString() + "\r\n");
                }
            }
            throw new RuntimeException("\r\n 接收数据错误！URI ==> " + request.getURI() + "\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            request.releaseConnection();
        }
    }
}