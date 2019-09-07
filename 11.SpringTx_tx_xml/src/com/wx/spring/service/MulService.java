package com.wx.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {
	
	@Autowired
	private BookService bookService;
	
	public void mulTx() {
		bookService.checkout("Tom", "ISBN-001");
		bookService.updatePrice("ISBN-002", 998);
		//int i = 10/0;
	}
}
