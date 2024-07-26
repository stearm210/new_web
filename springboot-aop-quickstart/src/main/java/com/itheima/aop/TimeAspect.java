package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component//当前类交于IOC容器管// 理
@Aspect//AOP容器问题
public class TimeAspect {

	//表明AOP的作用范围
	@Around("execution(* com.itheima.service.*.*(..))")//切入点表达式
	public Object recordTime(ProceedingJoinPoint joinPoint ) throws Throwable {
		//1.记录开始时间
		// 记录当前时间
		long begin = System.currentTimeMillis();

		//2.调用原始方法运行
		Object result = joinPoint.proceed();

		//3.记录结束时间，计算方法执行耗时
		long end=System.currentTimeMillis();
		//获得对应时间,并获得对应的签名
		log.info(joinPoint.getSignature()+"方法执行耗时:{}ms",end-begin);

		return result;
	}
}