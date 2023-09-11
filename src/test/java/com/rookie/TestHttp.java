package com.rookie;

import com.rookie.service.IHttpService;
import com.rookie.service.impl.OkHttpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Auther: Administrator
 * @Date: 2023/9/11 11:40
 * @Description:
 */
@Slf4j
public class TestHttp {

    private IHttpService httpService = new OkHttpServiceImpl();

    @Test
    public void test1() {
        String resp = httpService.get("http://www.baidu.com");
        log.info("resp:{}", resp);
    }

    @Test
    public void test2(){
        String resp = httpService.post("http://www.baidu.com", "{'name':'rookie'}");
        log.info("resp:{}", resp);
    }
}