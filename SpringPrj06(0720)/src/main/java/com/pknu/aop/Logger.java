package com.pknu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {
	
	@Pointcut("execution(void com.pknu.aop.*.Sound())")
	private void selectSound() {}
	
	@Before("selectSound()")
	public void aboutToSound() {
		System.out.print("before:about to sound");
		
		
	}
}
