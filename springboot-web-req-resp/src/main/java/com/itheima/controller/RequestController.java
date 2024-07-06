package com.itheima.controller;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/*
* 测试请求参数接收
* */
@RestController
public class RequestController {
    //原始方式
    //需要进行响应的请求路径(这里将函数进行了一个响应，返回对应的名字和年龄参数)
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        //通过request来获取请求的参数
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//
//        //进行类型转换
//        int age = Integer.parseInt(ageStr);
//
//        //返回字符串等数据
//        System.out.println(name+ ":" + age);
//        return "OK";
//
//    }


    //基于springboot方式的接收参数
    //注意，参数名字必须与postman中定义的参数名字是一样的
    @RequestMapping("/simpleParam")
    //这里如果加上"@RequestParam(name="name",required = false"就表示这个name参数不一定需要被传递。
    public String simpleParam(@RequestParam(name="name",required = false) String name, Integer age){
        //返回字符串等数据
        System.out.println(name+ ":" + age);
        return "OK";

    }


    //2.实体参数的方法，用于传递创建多个参数的问题配置
    //如果使用了类的方法封装，则只需要保证apipost中的参数名字与类中属性名一致即可

    //请求路径
    @RequestMapping("/simplePojo")

    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }


    //复杂的实体参数问题，如果有多个类属性嵌套的时候
    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        //输出apipost中输入的信息，并返回一个ok。这里相当于user这个对象已经在网页上创建成功了
        System.out.println(user);
        return "OK";
    }



    //3.数组参数的获取
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        //apipost中使用get方式将数据信息传入数组中，并且最后将信息进行输出
        //输出apipost中输入的信息，并返回一个ok。
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }





}