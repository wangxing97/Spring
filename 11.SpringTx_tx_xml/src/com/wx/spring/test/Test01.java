package com.wx.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.dao.BookDao;
import com.wx.spring.service.BookService;
import com.wx.spring.service.MulService;

class Test01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	void test() {
		MulService bean = ioc.getBean(MulService.class);
		bean.mulTx();
	}
	
	@Test
	void test02() {
		BookService bean = ioc.getBean(BookService.class);
	}

}
