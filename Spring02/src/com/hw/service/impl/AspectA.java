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
		
		System.out.println("��������쳣�ˣ�"+e.getMessage());
	}
	
	public void doAfter(){
		System.out.println("������ζ���ִ��After");
	}
	
	public void doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around..1");
		
		if((double)joinPoint.getArgs()[0]>0){
			joinPoint.proceed();
		}
		
		System.out.println("around..2");
	}
}
