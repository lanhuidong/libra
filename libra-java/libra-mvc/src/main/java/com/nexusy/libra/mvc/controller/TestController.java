package com.nexusy.libra.mvc.controller;

import com.nexusy.libra.model.RequestParams;
import com.nexusy.libra.model.ResponseData;
import com.nexusy.libra.util.JsonMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lanhuidong
 * @since 2019-07-24
 */
@RestController
public class TestController {

    @RequestMapping("/api/v1/test")
    public void test(@RequestBody RequestParams requestParams, HttpServletResponse response) {
        ResponseData responseData = new ResponseData();
        responseData.setRequestId(requestParams.getRequestId());
        responseData.setClientTime(requestParams.getClientTime());
        responseData.setServerTime(System.currentTimeMillis());
        byte[] data = JsonMapper.writeValue(responseData);
        response.setContentLength(data.length);
        response.setContentType("application/json");
        try {
            response.getOutputStream().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
