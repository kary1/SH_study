package com.hw.service.impl;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectB {
	
	@Pointcut("execution(* com.hw.service.*.*(..))")
	public void pointcut(){}
	
	@Before("execution(* com.hw.service.*.*(..))")
	public void before(){
		System.out.println("aspectB_before");
	}
	
	@After("pointcut()")
	public void after(){
		System.out.println("aspectB_After");
	}
	
	@AfterThrowing(pointcut="execution(* com.hw.service.*.*(..))",throwing="e")
	public void throwing(Throwable e){
		System.err.println(e.getMessage());
	}
	
}
