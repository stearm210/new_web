package com.itheima.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//这里使用idea中的java代码来编写mysql语句，主要是方便编写代码.
@Mapper//运行时，会自动生成接口的实现类对象(这个对象是一个代理类对象)，这个实现类对象会自动的交给ioc容器管理

//这里使用一个接口用于操作SQL语句等信息
public interface UserMapper {
    //查询全部的用户信息
    //使用一个sql语句进行查询

    @Select("select * from user")
    public List<User> list();
}