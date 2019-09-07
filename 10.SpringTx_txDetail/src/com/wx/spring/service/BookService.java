package com.wx.spring.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wx.spring.dao.BookDao;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	/*
	     REQUIRED：支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择,当有任何异常发生的时候，所有操作回滚。 

		 SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行,抛出的异常不会导致 serviceA回滚。 
		
		 MANDATORY：支持当前事务，如果当前没有事务，就抛出异常。 
		
		 REQUIRES_NEW：新建事务，如果当前存在事务，把当前事务挂起。 
		
		 NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。 
		
		 NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。 
		
		 NESTED：支持当前事务，如果当前事务存在，则执行一个嵌套事务，如果当前没有事务，就新建一个事务。 
	*/
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void checkout(String username,String isbn) {
		bookDao.updateStock(isbn);
		int price = bookDao.getBookPrice(isbn);
		bookDao.updateBalance(username, price);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updatePrice(String isbn,int price) {
		bookDao.updatePrice(isbn, price);
		//int i = 10/0;
	}
	
	public int getPrice(String isbn) {
		return bookDao.getBookPrice(isbn);
	}
}
