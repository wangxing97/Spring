package com.wx.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.spring.dao.BookDao;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public void save() {
		System.out.println("正在为你保存图书...");
		bookDao.opera();
	}
}
