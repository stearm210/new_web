package com.itheima.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 测试请求参数接收
* */
@RestController
public class RequestController {
    //原始方式
    //需要进行响应的请求路径(这里将函数进行了一个响应，返回对应的名字和年龄参数)
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        //通过request来获取请求的参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        //进行类型转换
        int age = Integer.parseInt(ageStr);

        //返回字符串等数据
        System.out.println(name+":"+age);
        return "OK";

    }

}