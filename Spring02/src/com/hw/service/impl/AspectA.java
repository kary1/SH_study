package com.hw.service.impl;

import org.aspectj.lang.ProceedingJoinPoint;

import com.hw.util.Utils;

public class AspectA {
	
	public void doBefore(){
		System.out.println("before...");
	}
	
	public void doAfterReturning(){
		System.out.println("doAfterReturning...");
	}
	
	public void doAfterThrowing(Throwable e){
		
		Utils.writeLog(e.toString());
		
		System.out.println("程序出现异常了！"+e.getMessage());
	}
	
	public void doAfter(){
		System.out.println("无论如何都会执行After");
	}
	
	public void doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around..1");
		
		if((double)joinPoint.getArgs()[0]>0){
			joinPoint.proceed();
		}
		
		System.out.println("around..2");
	}
}
