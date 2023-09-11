package com.rookie.service.impl;

import com.rookie.service.IHttpService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Administrator
 * @Date: 2023/9/11 11:13
 * @Description: okhttp 服务
 */
@Slf4j
public class OkHttpServiceImpl implements IHttpService<OkHttpClient> {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private OkHttpClient client;

    public OkHttpServiceImpl() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        ;
    }

    public String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            log.error("okhttp get error", e);
            return null;
        }
    }

    @Override
    public String post(String url, String json) {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            log.error("okhttp post json error", e);
            return null;
        }
    }
}