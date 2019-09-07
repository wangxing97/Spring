package com.wx.spring.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
public class ValidateAspect {
	
	public static void startLog(JoinPoint joinPoint) {
		System.out.println("[ValAspect-前置]["+joinPoint.getSignature().getName()+"]方法正在执行，参数列表："+Arrays.asList(joinPoint.getArgs()));
	}
	
	public static void returnLog(JoinPoint joinPoint,Object result) {
		System.out.println("[ValAspect-返回]["+joinPoint.getSignature().getName()+"]方法执行完成，计算结果："+result);
	}
	
	public static void exceptionLog(JoinPoint joinPoint,Exception e) {
		System.out.println("[ValAspect-异常]["+joinPoint.getSignature().getName()+"]方法执行异常，错误信息："+e);
	}
	
	public static void finalyLog(JoinPoint joinPoint) {
		System.out.println("[ValAspect-后置]["+joinPoint.getSignature().getName()+"]方法最终执行完成");
	}
}
