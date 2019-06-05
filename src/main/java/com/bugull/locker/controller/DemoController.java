package com.bugull.locker.controller;

import com.bugull.locker.response.ApiResult;
import com.bugull.locker.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: locker
 * @description: demo
 * @author: Carver Zhang
 * @create: 2019-06-05 09:26
 **/
@Slf4j
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/demo")
    public ApiResult<String> HelloWorld() {
        return ApiResult.success(demoService.strDemo());
    }
}
