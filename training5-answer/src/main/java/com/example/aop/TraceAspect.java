package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.example.business.domain.Message;

@Aspect
public class TraceAspect {

	@After("execution(* com.example.business.service.MessageService.findOne())")
	public void after() {
		// メソッド終了後にWeavingするAdvice
		System.out.println("after called");
	}

	@Before("execution(* *..MessageService.findOne())")
	public void before() {
		// メソッド開始時にWeavingするAdvice
		System.out.println("before called");
	}

	@Around("execution(* com.example.business.service.MessageServiceImpl.find*())")
	public Message around(ProceedingJoinPoint pjp) throws Throwable {
		// メソッド呼出の前後にWeavingするAdvice
		System.out.println("プレ proceed");

		Signature sig = pjp.getSignature();
		System.out.println("Sig: " + sig.getName());
		Message msg = (Message) pjp.proceed();
		System.out.println("ポスト proceed");
		return msg;
	}

	@AfterReturning(value = "execution(* *..MessageService.findOne(..))", returning = "ret")
	public void afterReturning(Message ret) {
		// メソッド呼出が例外の送出なしに終了した際に呼ばれるAdvice
		System.out.println("after returning called");
		System.out.println("return value = " + ret.getValue());
	}

	@AfterThrowing(value = "execution(* *())", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		// メソッド呼出が例外の送出なしに終了した際に呼ばれるAdvice
		System.out.println("after throwing called");
		System.out.println("exception value = " + ex.toString());
	}
}