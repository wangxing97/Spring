package com.wx.spring.dao;

import org.springframework.stereotype.Repository;

@Repository("book01")
public class BookDao {
	
	public void opera() {
		System.out.println("图书已保存...");
	}
}
