package com.lsc.startproject.core.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author halink
 * @date 2019/11/17 12:02 上午
 */
@Slf4j
public class HttpClientUtil {

    public static String doGet(String url, Map<String, String> param) {
        String resultString = "";
        CloseableHttpResponse response = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    builder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }

    public static String doPost(String url, Map<String, String> param) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return resultString;
    }

    public static String doPost(String url) {
        return doPost(url, null);
    }

    public static String doPostJson(String url, String json) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return resultString;
    }
}
