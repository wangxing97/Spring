package com.wx.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.service.BookService;
import com.wx.spring.service.UserService;

class IOCTest01 {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	
	@Test
	void test() {
		BookService bookService = ioc.getBean(BookService.class);
		UserService userService = ioc.getBean(UserService.class);
		bookService.save();
		userService.save();
		
		System.out.println(bookService.getClass().getGenericSuperclass());
		
		/*
		 * IOC是一个容器，帮我们管理所有组件
		 * 		1、依赖注入：@Autowired
		 * 		2、某个组件要使用的Spring提供的更多（IOC、AOP）必须加到容器中
		 * 	
		 * 体会：
		 * 		1、容器启动。创建所有单实例bean
		 * 		2、Autowired自动装配的时候，是从容器中找到这些符合要求的bean
		 * 		3、ioc.getBean(“bookServlet”);也是从容器中找到这个bean
		 * 		4、容器中包括了所有的bean
		 * 		5、容器其实就是一个map
		 * 		6.这个map中保存所有创建好的bean，并且提供外界获取功能
		 * 		7、探索，单实例的bean都保存在哪个map中了。
		 * 		8、源码调试的思路就是从helloword中开始的：给每一个关键步骤打断点进行观看。
		 */
	}

}
