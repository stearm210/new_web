package com.itheima.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解什么时候生效，这里写的是运行时生效
@Retention(RetentionPolicy.RUNTIME)

//当前这个注解可以在哪些路径、范围生效
@Target(ElementType.METHOD)
public @interface MyLog {
}
