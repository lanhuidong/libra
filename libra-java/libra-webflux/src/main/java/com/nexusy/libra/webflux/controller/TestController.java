package com.nexusy.libra.webflux.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author lanhuidong
 * @since 2019-07-24
 */
@RestController
public class TestController {

    @RequestMapping("/api/v1/test")
    public Mono<ResponseData> test(@RequestBody RequestParam requestParams) {
        ResponseData responseData = new ResponseData();
        responseData.setRequestId(requestParams.getRequestId());
        responseData.setClientTime(requestParams.getClientTime());
        responseData.setServerTime(System.currentTimeMillis());
        return Mono.just(responseData);
    }
}
