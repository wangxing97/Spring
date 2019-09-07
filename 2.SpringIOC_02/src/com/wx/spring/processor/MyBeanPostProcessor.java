package com.wx.spring.processor;

import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	/*
	 * 1、编写后置处理器的实现类
	 * 2、将后置处理器注册在配置文件中
	 * String beanName:就是在xml中配置的id
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("初始化之前...【"+beanName+"】bean将要调用初始化方法了....这个bean是【"+bean+"】");
		//返回传入的bean ，这里的bean可以更改
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("初始化之后...zzzzzzzzz【"+beanName+"】");
		//这里返回的是什么，容器保存的就是什么
		return null;
	}

	

}
