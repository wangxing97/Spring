package com.wx.spring.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {

	public static void startLog(Method method,Object[] args) {
		System.out.println("["+method.getName()+"]方法正在执行，参数列表："+Arrays.asList(args));
	}
	public static void returnLog(Method method,Object result) {
		System.out.println("["+method.getName()+"]方法执行完成，计算结果："+result);
	}
	public static void exceptionLog(Method method,Exception e) {
		System.out.println("["+method.getName()+"]方法执行异常，错误信息："+e.getCause());
	}

}
