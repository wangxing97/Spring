package com.wx.spring.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.bean.Person;
public class IocTest01 {

	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc1.xml");
	
	/*
	 * src：源码包开始的路径，所有的源代码里面的东西都会被合并放在类路径里面，也就是bin里
	 * 从容器中拿到这个组件
	 * */
	@Test
	public void test() {
		//ApplicationContext:代表Ioc容器
		//ClassPathXmlApplicationContext:当前应用的xml配置文件在ClassPath下
		//根据Spring的配置文件得到Ioc容器对象
		//容器中对象的创建在容器创建的时候就自动创建好了对象
		//容器帮我们创建好了对象
		//Ioc容器在创建这个对象的时候，property会利用setter方法为属性赋值
		//javaBean的属性名是由什么决定的？
		// private String lastName?
		// 是由getter/setter方法set去掉后面那一串才是属性名
		Person person01 = (Person) ioc.getBean("person01");
		Person person02 = (Person) ioc.getBean("person01");
		System.out.println(person01);
		//获取同一个组件，在ioc容器中是单实例的,都是一个对象
		System.out.println(person01 == person02);
	}
	//*.launch
	
	/*
	 * 实验2：根据bean的类型从Ioc容器中获取bean的实例***
	 * 注意：按照类型找bean，如果有多个会报错
	 * 
	 * 实验3：通过构造器为bean的属性赋值（index，type属性介绍）
	 * 通过p名称空间为bean赋值
	 */
	@Test
	public void test02() {
		//Person bean = ioc.getBean(Person.class);
		//System.out.println(bean);
		//可以通过下例来找到bean，并且不用强转类型
//		Person bean2 = ioc.getBean("person02", Person.class);
//		System.out.println(bean2);
//		
//		Object bean = ioc.getBean("person03");
//		System.out.println(bean);
		Object bean3 = ioc.getBean("person04");
		System.out.println(bean3);
		
		Object bean4 = ioc.getBean("person05");
		System.out.println(bean4);
	}

}
