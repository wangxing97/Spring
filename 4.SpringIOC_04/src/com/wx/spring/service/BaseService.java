package com.wx.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wx.spring.Dao.BaseDao;

public class BaseService<T> {
	
	@Autowired
	BaseDao<T> baseDao;
	
	public void save() {
		System.out.println("自动注入的类型："+baseDao);
		baseDao.save();
	}
}
