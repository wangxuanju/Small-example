package com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect {
	@Before("execution(* com.Caculator.*(..))&& args(a,..)")
	private void arithmeticDolog(JoinPoint jp,int a){
		System.out.println(a + ":" + jp.toString());
	}

}
