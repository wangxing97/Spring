package com.wx.spring.test;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.bean.Person;
public class IocTest02 {

	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
	
	/*
	 * 实验4:正确的为各种属性赋值
	 * 测试使用null值：<!-- 不写就默认为null -->
	 * 引用类型赋值（引用其他bean、引用内部bean）
	 * 集合类型赋值（List、Map、Properties）
	 * 		util名称空间创建集合类型的bean
	 * 级联属性赋值
	 */
	@Test
	public void test01() {
		Person bean = (Person) ioc.getBean("person01");
		System.out.println(bean.getLastName() == null);
		//引用的和直接getbean是同一个，这里修改，容器里的也会变，ref严格引用
		Person bean02 = (Person) ioc.getBean("person02");
		System.out.println(bean02.getCar());
		
		Person bean03 = (Person) ioc.getBean("person03");
		//内部bean 不能被获取到***********
		System.out.println(bean03.getBooks());
		
		System.out.println(bean03.getMaps());
		
		System.out.println(bean03.getProperties());
		
		System.out.println("*****************************");
		Person bean04 = (Person) ioc.getBean("person04");
		System.out.println(bean04.getMaps());
		
		Object bean2 = ioc.getBean("reflist");
		System.out.println(bean2);
		
		Person bean3 = (Person) ioc.getBean("person06");
		System.out.println(bean3.getCar());
	}
	
	/*
	 * 实验6：通过继承实现bean配置信息的重用
	 * 实验7：通过abstract属性创建一个模板bean
	 * 实验8：bean之间的依赖（在ioc3里面...）
	 * 实验9：测试bean的作用域，分别创建单实例和多实例的bean（重点）（在ioc3里面...）
	 */
	@Test
	public void test02(){
		Person bean = (Person) ioc.getBean("person08");
		System.out.println(bean);
	}
}
