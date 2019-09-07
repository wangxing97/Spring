package com.wx.spring.factory;

import java.util.UUID;

import org.springframework.beans.factory.FactoryBean;

import com.wx.spring.bean.Book;

public class MyFactoryImpl implements FactoryBean<Book>{

	@Override
	public Book getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FactoryBean正在造书。。。。。。");
		Book book = new Book();
		book.setBookName(UUID.randomUUID().toString());
		return book;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
