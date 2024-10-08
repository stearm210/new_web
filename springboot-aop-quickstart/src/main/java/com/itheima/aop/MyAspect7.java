package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//切面类
@Slf4j
@Component
@Aspect
public class MyAspect7 {
	//匹配DeptServiceImpl中的 list() 和 delete(Integer id)方法
	//@Pointcut("execution(* com.itheima.service.DeptService.list()) || execution(* com.itheima.service.DeptService.delete(java.lang.Integer))")
	//
	//annotation表达式主要用于自定义注解方式,只要是service层的实现类中的实现方法上加上了MyLog注解，就可以使用到这个注解对应的操作
	@Pointcut("@annotation(com.itheima.aop.MyLog)")
	private void pt(){

	}
	@Before("pt()")
	public void before(){
		log.info("MyAspect7... before...");
	}

}