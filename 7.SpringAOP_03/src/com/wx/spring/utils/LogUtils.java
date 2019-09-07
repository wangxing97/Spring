package com.wx.spring.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
public class LogUtils {

	public static void startLog(JoinPoint joinPoint) {
		System.out.println("[LogUtils-前置]["+joinPoint.getSignature().getName()+"]方法正在执行，参数列表："+Arrays.asList(joinPoint.getArgs()));
	}
	
	public static void returnLog(JoinPoint joinPoint,Object result) {
		System.out.println("[LogUtils-返回]["+joinPoint.getSignature().getName()+"]方法执行完成，计算结果："+result);
	}
	
	public static void exceptionLog(JoinPoint joinPoint,Exception e) {
		System.out.println("[LogUtils-异常]["+joinPoint.getSignature().getName()+"]方法执行异常，错误信息："+e);
	}
	
	public static void finalyLog(JoinPoint joinPoint) {
		System.out.println("[LogUtils-后置]["+joinPoint.getSignature().getName()+"]方法最终执行完成");
	}
	
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		//利用反射调用目标方法  == method.invoke(obj,args)
		Object[] args = pjp.getArgs();
		Object proceed = null;
		try {
			System.out.println("环绕前置通知..");
			proceed = pjp.proceed(args);
			System.out.println("环绕返回通知..");
		} catch (Exception e) {
			//为了让外界感知到异常，需要将异常抛出去
			System.out.println("环绕异常通知..");
			throw new RuntimeException(e);
		}finally {
			System.out.println("环绕后置通知..");
		}
		//反射调用后的返回值也一定返回出去
		return proceed;
	}
}
