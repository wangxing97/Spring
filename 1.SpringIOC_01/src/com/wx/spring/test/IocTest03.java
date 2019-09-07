package com.wx.spring.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.bean.AirPlane;
public class IocTest03 {

	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");

	@Test
	public void test01() {
		Object bean = ioc.getBean("book02");
		Object bean2 = ioc.getBean("book02");
		System.out.println(bean == bean2);
		
		/*
		 * 实验5：配置通过静态工厂方法创建bean，实例工厂方法创建的bean、FactoryBean （重点）
		 */
		
		AirPlane bean3 = (AirPlane) ioc.getBean("airplane01");
		System.out.println(bean3);
		
		Object bean4 = ioc.getBean("airplane02");
		System.out.println(bean4);
	}
	
	@Test
	public void test02() {
		//FactoryBean只有在获取的时候才创建对象
		//若设置isSingleton = false 则是多实例 会创建多次
		// true单实例会创建一次
		Object bean = ioc.getBean("myFactoryImpl");
		Object bean1 = ioc.getBean("myFactoryImpl");
		System.out.println(bean == bean1);
	}

}
