package com.itheima.controller;

import com.itheima.pojo.Address;
import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试响应数据
 */
//@ResponseBody将方法返回值直接响应，如果返回值类型是 实体对象/集合，将会转换为ISON格式响应
//位置:Controller方法上/类上

@RestController
public class ResponseController {

//    @RequestMapping("/hello")
//    public String hello(){
//        System.out.println("Hello World ~");
//        return "Hello World ~";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr(){
//        Address addr = new Address();
//        addr.setProvince("广东");
//        addr.setCity("深圳");
//        return addr;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr(){
//        List<Address> list = new ArrayList<>();
//
//        Address addr = new Address();
//        addr.setProvince("广东");
//        addr.setCity("深圳");
//
//        Address addr2 = new Address();
//        addr2.setProvince("陕西");
//        addr2.setCity("西安");
//
//        list.add(addr);
//        list.add(addr2);
//        return list;
//    }

    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("Hello World ~");
        //这里是返回了一个对象，注意这个对象有三个属性
//        return new Result(1,"success","hello world");
        return Result.success("Hello World");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.success(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("陕西");
        addr2.setCity("西安");

        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }

}
