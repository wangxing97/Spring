package com.wx.spring.Dao;

import org.springframework.stereotype.Repository;

import com.wx.spring.bean.Book;

@Repository
public class BookDao extends BaseDao<Book>{

	@Override
	public void save() {
		System.out.println("图书正在保存...");
	}

}
