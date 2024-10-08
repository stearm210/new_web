package com.itheima.controller;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
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

    //集合的请求路径问题
    //使用@RequestParam 将多个请求参数的值封装到list队列中
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        //apipost中使用get方式将数据信息传入数组中，并且最后将信息进行输出
        //输出apipost中输入的信息，并返回一个ok。
        System.out.println(hobby);
        return "OK";
    }



    //4.日期时间参数
    //使用 @DateTimeFormat 注解完成日期参数格式转换
    //这个LocalDateTime用于定义与封装时间
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    //5.JSON数据传输
    //JSON参数:JSON数据键名与形参对象属性名相同，定义POJ0类型形参即可接收参数，需要使用 @RequestBody 标识
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

    //6.路径参数
    //由于路径不一定是一样的，因此需要使用一个id来代表网页路径
    //使用@PathVariable来将路径绑定为id，使得可以获取路径参数信息
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }


    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }

}