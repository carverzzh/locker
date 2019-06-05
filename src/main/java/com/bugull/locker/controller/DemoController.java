package com.bugull.locker.controller;

import lombok.extern.slf4j.Slf4j;
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

    @RequestMapping(value = "/demo")
    public String HelloWorld() {
        return "Hello World";
    }
}
