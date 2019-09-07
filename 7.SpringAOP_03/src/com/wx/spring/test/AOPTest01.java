package com.wx.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.impl.MyMathCalculator;
import com.wx.spring.inter.Calculator;

class AOPTest01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	@Test
	void test() {
		MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
		bean.add(1, 2);
	}

}
