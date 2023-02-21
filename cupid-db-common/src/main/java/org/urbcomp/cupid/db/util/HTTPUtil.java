/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author jimo
 **/
public class HTTPUtil {

    public static String post(String url, String body) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
        final CloseableHttpClient httpClient = getClient();
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                httpPost.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            }
            EntityUtils.consume(entity);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeClient(httpClient);
        }
    }

    public static String get(String url) {
        final CloseableHttpClient httpClient = getClient();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            }
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeClient(httpClient);
        }
    }

    private static CloseableHttpClient getClient() {
        RequestConfig config = RequestConfig.custom()
            .setConnectTimeout(60000)
            .setSocketTimeout(15000)
            .build();
        return HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    private static void closeClient(CloseableHttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
