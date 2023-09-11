package com.rookie.service;

/**
 * @Auther: Administrator
 * @Date: 2023/9/11 11:12
 * @Description: http 服务
 */
public interface IHttpService<T> {

    /**
     * get 请求
     *
     * @param url 请求地址
     * @return 响应
     */
    String get(String url);

    /**
     * post 请求
     *
     * @param url  请求地址
     * @param json 请求参数
     * @return 响应
     */
    String post(String url, String json);
}