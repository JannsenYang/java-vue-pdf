package com.jannsen.javavuepdf.utils;

import com.google.common.io.CharStreams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static String get(String url) {
        HttpGet http = new HttpGet(url);
        http.setHeader("accept", "application/json");
        http.setHeader("connection", "Keep-Alive");
        http.setHeader("user-web", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        http.setHeader("Content-type", ContentType.APPLICATION_JSON.toString());
        return call(http);
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