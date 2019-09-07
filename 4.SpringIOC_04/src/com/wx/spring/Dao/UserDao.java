package com.wx.spring.Dao;

import org.springframework.stereotype.Repository;

import com.wx.spring.bean.User;

@Repository
public class UserDao extends BaseDao<User>{

	@Override
	public void save() {
		System.out.println("用户正在保存...");
	}

}
