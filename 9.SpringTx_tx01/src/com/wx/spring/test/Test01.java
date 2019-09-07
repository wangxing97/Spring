package com.wx.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.dao.BookDao;
import com.wx.spring.service.BookService;

class Test01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	void test() {
		BookDao bean = ioc.getBean(BookDao.class);
		int bookPrice = bean.getBookPrice("ISBN-001");
		System.out.println(bookPrice);
	}
	
	@Test
	void test02() {
		BookService bean = ioc.getBean(BookService.class);
		bean.checkout("Tom", "ISBN-002");
	}
	
	@Test
	void test03() throws FileNotFoundException {
		BookService bean = ioc.getBean(BookService.class);
		bean.checkout1("Tom", "ISBN-002");
	}
	
	@Test
	void test04() throws FileNotFoundException {
		BookService bean = ioc.getBean(BookService.class);
		int price = bean.getPrice("ISBN-001");
		System.out.println(price);
	}

}
