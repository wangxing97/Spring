package com.wx.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.servlet.BookServlet;
class IOCTest01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	/*
	 * 使用注解加入到容器的组件和在XML文件中配置的组件行为都是一样的
	 * 1、组件的id。默认就是组件的类名首字母小写
	 * 2、组件的作用域。默认是单实例的
	 *    @Scope(value="prototype")
	 */
	@Test
	void test() {
		Object bean = ioc.getBean("book01");
		Object bean1 = ioc.getBean("book01");
		System.out.println(bean == bean1);
	}

	@Test
	void test02() {
		BookServlet bean = (BookServlet) ioc.getBean("bookServlet");
		bean.doGet();
	}
}
