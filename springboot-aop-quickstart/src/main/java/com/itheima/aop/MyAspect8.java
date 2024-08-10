package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect8 {

	@Pointcut("execution(* com.itheima.service..DeptService.*(..))")
	private void pt(){

	}

	//前置通知
	@Before("pt()")
	public void before(JoinPoint joinPoint){
		log.info("MyAspect8 before");
	}

	//环绕通知
	@Around("pt()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("MyAspect8 around");

		//1.获取目标对象的类名
		String className = joinPoint.getTarget().getClass().getName();
		log.info("获取目标对象的类名:{}", className);

		//2.获取目标方法的方法名
		String methodName = joinPoint.getSignature().getName();
		log.info("目标方法的方法名:{}", methodName);

		//3.获取目标方法运行时植入的参数
		Object[] args = joinPoint.getArgs();
		log.info("目标方法运行时传入的参数:{}", Arrays.toString(args));

		//4.放行目标方法执行
		Object result = joinPoint.proceed();

		//5.获取目标方法运行的返回值
		log.info("获取目标方法运行的返回值:{}",result);
		log.info("MyAspect8 around");
		return result;


	}


}