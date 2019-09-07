package com.wx.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wx.spring.bean.Car;

class IocTest01 {

	//文件路径获取 可以不放在lib下
	//ApplicationContext ioc = new FileSystemXmlApplicationContext("D:\\SpringCode\\2.SpringIOC_02\\bin\\applicationContext.xml");
	//注意：需要加上IOC容器的全名字，不可少xml后缀
	//ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	ApplicationContext ioc2 = new ClassPathXmlApplicationContext("applicationContext02.xml");
	/*
	 * 单实例Bean的生命周期
	 *       构造器--->初始化方法--->销毁方法
	 * 多实例Bean的生命周期
	 *       只有获取的时候才会初始化
	 *       销毁的时候不会调用bean的销毁
	 * 
	 *后置处理器：有点类似Filter
	 *       构造器--->后置处理器的before--->初始化方法--->后置处理器after--->销毁方法
	 *
	 */
	@Test
	void test() {
		//Ctrl+T快捷看这个同名方法的父类、子类、接口。
		/*Object bean = ioc.getBean("book01");
		System.out.println(bean);*/
	}
	
	@Test
	void test02() throws SQLException {
		/*Object bean = ioc2.getBean("comboPooledDataSource");
		System.out.println(bean);*/
		//注意：不止要导入c3p0.jar，还要导入mchange-commons-java.jar 不然会报错
		DataSource bean = ioc2.getBean(DataSource.class);
		System.out.println(bean.getConnection());
		
		Car bean2 = ioc2.getBean(Car.class);
		System.out.println(bean2);
	}

}



