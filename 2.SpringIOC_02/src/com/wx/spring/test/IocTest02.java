package com.wx.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wx.spring.bean.Car;
import com.wx.spring.bean.Person;

class IocTest02 {

	ApplicationContext ioc2 = new ClassPathXmlApplicationContext("applicationContext03.xml");
	
	@Test
	void test() {
		Person bean = (Person) ioc2.getBean("person01");
		System.out.println(bean);
	}
	
	@Test
	void test02() throws SQLException {
		Person bean = (Person) ioc2.getBean("person02");
		System.out.println(bean);
	}

}



