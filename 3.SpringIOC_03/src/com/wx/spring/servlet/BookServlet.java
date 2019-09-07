package com.wx.spring.servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.wx.spring.dao.BookDao;
/*
 * 属性的自动注入
 * @Autowired：Spring会自动为这个属性赋值
 * 			    一定是去容器中找到这个属性对应的值，如果容器里都没有，自动装配会报错
 */
import com.wx.spring.service.BookService;

@Controller
public class BookServlet {
	
	//自动装配
	@Qualifier("bookServiceExt123")
	@Autowired(required = false)
	private BookService bookServiceExt2;
	
	public void doGet() {
		System.out.println("BookServlet........."+bookServiceExt2);
		//bookServiceExt2.save();
	}
	
	/*
	 * 方法上有@Autowired的话，
	 * 1)、这个方法也会在bean创建的时候自动运行
	 * 2)、这个方法上的每一个参数都会自动注入值
	 */
	@Autowired
	public void hahaha(BookDao bookDao,@Qualifier("bookServiceExt") BookService bookService) {
		System.out.println(bookDao+"===>"+bookService);
	}
}
