package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect6 {
	//@Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
	//@Pointcut("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
	//@Pointcut("execution(void delete(java.lang.Integer))") //包名.类名不建议省略
	//@Pointcut("execution(void com.itheima.service.DeptService.delete(java.lang.Integer))")

	//@Pointcut("execution(void com.itheima.service.DeptService.*(java.lang.Integer))")
	//@Pointcut("execution(* com.*.service.DeptService.*(*))")
	//@Pointcut("execution(* com.itheima.service.*Service.delete*(*))")

	//@Pointcut("execution(* com.itheima.service.DeptService.*(..))")
	//@Pointcut("execution(* com..DeptService.*(..))")
	//@Pointcut("execution(* com..*.*(..))")
	//@Pointcut("execution(* *(..))") //慎用
	//@Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")

	//下面是delete()方法和getID方法的切入点表达式
	@Pointcut("execution(* com.itheima.service.DeptService.list()) ||" + "execution(* com.itheima.service.DeptService.delete(java.lang.Integer))")

	private void pt(){

	}

	@Before("pt()")
	public void before(){
		log.info("MyAspect6....  before.....");
	}
}