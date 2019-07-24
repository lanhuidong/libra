package com.nexusy.libra.mvc.controller;

import com.nexusy.libra.model.RequestParams;
import com.nexusy.libra.model.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanhuidong
 * @since 2019-07-24
 */
@RestController
public class TestController {

    @RequestMapping("/api/v1/test")
    public ResponseData test(@RequestBody RequestParams requestParams) {
        ResponseData responseData = new ResponseData();
        responseData.setRequestId(requestParams.getRequestId());
        responseData.setClientTime(requestParams.getClientTime());
        responseData.setServerTime(System.currentTimeMillis());
        return responseData;
    }
}
