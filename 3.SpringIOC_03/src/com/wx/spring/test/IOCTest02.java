package com.wx.spring.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.spring.service.BookService;
import com.wx.spring.servlet.BookServlet;
/*
 * 使用Spring的单元测试
 * 1、导包 spring-test-3.2.4.RELEASE.jar
 * 2、@ContextConfiguration(locations = "")使用它来指定Spring的配置文件的路径
 * 3、@RunWith()指定用哪种驱动进行单元测试，默认是junit
 * 		@RunWith(SpringJUnit4ClassRunner.class)
 * 		使用Spring的单元测试模块来执行标了@Test的方法
 */

//找不到xml文件，估计是JUnit4 和 JUnit5不兼容？？
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
class IOCTest02 {

	//ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	ApplicationContext ioc = null;
	
	@Autowired
	BookServlet bookServlet;
	@Autowired
	BookService bookService;
	
	@Test
	void test01() {
		System.out.println(bookServlet);
		System.out.println(bookService);
	}
}
