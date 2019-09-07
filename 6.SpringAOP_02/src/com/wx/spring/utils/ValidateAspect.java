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

@Aspect
@Component
@Order(2) //使用Order改变切面顺序，数值越小优先级越高
public class ValidateAspect {
	
	@Before("com.wx.spring.utils.LogUtils.testEmpty()")
	public static void startLog(JoinPoint joinPoint) {
		System.out.println("[ValAspect-前置]["+joinPoint.getSignature().getName()+"]方法正在执行，参数列表："+Arrays.asList(joinPoint.getArgs()));
	}
	
	@AfterReturning(value = "com.wx.spring.utils.LogUtils.testEmpty()",returning = "result")
	public static void returnLog(JoinPoint joinPoint,Object result) {
		System.out.println("[ValAspect-返回]["+joinPoint.getSignature().getName()+"]方法执行完成，计算结果："+result);
	}
	
	@AfterThrowing(value = "com.wx.spring.utils.LogUtils.testEmpty()",throwing = "e")
	public static void exceptionLog(JoinPoint joinPoint,Exception e) {
		System.out.println("[ValAspect-异常]["+joinPoint.getSignature().getName()+"]方法执行异常，错误信息："+e);
	}
	
	@After("com.wx.spring.utils.LogUtils.testEmpty()")
	public static void finalyLog(JoinPoint joinPoint) {
		System.out.println("[ValAspect-后置]["+joinPoint.getSignature().getName()+"]方法最终执行完成");
	}
}
