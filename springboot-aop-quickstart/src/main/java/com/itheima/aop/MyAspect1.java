package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect1 {

    //定义一个共同路径
    //里面接上一个切入点表达式
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}

    //原始方法执行之前执行对应的操作
    @Before("pt()")
    public void before(){
        log.info("before ...");
    }


    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        //如果原始方法出现异常，则后面的代码不会运行
        log.info("around after ...");
        return result;//返回对应的时间
    }

    //原始方法运行之后执行对应的操作
    @After("pt()")
    public void after(){
        log.info("after ...");
    }

    //原始方法正常返回执行对应的操作
    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning ...");
    }

    //原始方法出现异常时返回
    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing ...");
    }
}
