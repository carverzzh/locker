package com.bugull.locker.controller;

import com.bugull.locker.entity.Demo;
import com.bugull.locker.response.ApiResult;
import com.bugull.locker.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: locker
 * @description: demo
 * @author: Carver Zhang
 * @create: 2019-06-05 09:26
 **/
@Api(description = "Demo")
@Slf4j
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "strDemo", notes = "str demo")
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public ApiResult<String> HelloWorld() {
        return ApiResult.success(demoService.strDemo());
    }

    @ApiOperation(value = "查询demo列表", notes = "查询demo列表")
    // 参数swagger注解
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "xxx", value = "xxx", required = true, paramType = "query", dataType = "String")
    })*/
    @RequestMapping(value = "/queryDemo", method = RequestMethod.GET)
    public ApiResult<List<Demo>> queryDemo() {
        return ApiResult.success(demoService.queryDemo());
    }
}
