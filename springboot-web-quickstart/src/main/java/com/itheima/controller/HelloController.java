package com.itheima.controller;

import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@RestController
public class HelloController{
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "hello world";

    }
}