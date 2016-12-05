package com.example.web04.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component // 스프링에서 관리하는 bean
@Aspect    // 스프링에서 관리하는 aop bean
public class LogAdvice {
// 포인트 컷 - 실행 시점, Around - 실행 전후
	// Before, After, Around
	// 컨트롤의 모든 method 실행 전후에 logPrint method 가 호출 됨.
	@Around("execution(* com.example.web04.controller..*Controller.*(..))"
			+ " or execution(* com.example.web04.service..*Impl.*(..))"
			+ " or execution(* com.example.web04.model..dao.*Controller.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		// 시스템의 현재 시간
		long startTime = System.currentTimeMillis();
		
		// 클래스 이름
		String type=joinPoint.getSignature().getDeclaringTypeName();
		// method 이름
		String method = joinPoint.getSignature().getName();
		// 매개변수
		String args=Arrays.toString(joinPoint.getArgs());
		System.out.println("클래스 : " + type);
		System.out.println("method : " + method);
		System.out.println("매개변수 : " + args);
		
		long endTime = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (endTime - startTime));
		System.out.println("======================================================");
		return joinPoint.proceed(); // 컨트롤러의 method 가 실행 됨.
	}
	
}
