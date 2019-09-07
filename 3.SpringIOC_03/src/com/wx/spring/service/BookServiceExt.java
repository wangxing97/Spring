package com.wx.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.spring.dao.BookDao;

@Service
public class BookServiceExt extends BookService{
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public void save() {
		System.out.println("BookService扩展正在调用...");
		bookDao.opera();
	}
}
