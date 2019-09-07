package com.wx.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	/*
	 * 1、减余额
	 */
	public void updateBalance(String username,int price) {
		String sql = "update account set balance=balance-? where username = ?";
		jdbcTemplate.update(sql, price,username);
	}
	
	/*
	 * 2、获取某本图书的价格
	 */
	public int getBookPrice(String isbn) {
		String sql = "select price from book where isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class,isbn);
	}
	
	/*
	 * 3、减库存
	 */
	public void updateStock(String isbn) {
		String sql = "update book_stock set stock=stock-1 where isbn=?";
		jdbcTemplate.update(sql, isbn);
	}
	/*
	 * 4、修改价格
	 */
	public void updatePrice(String isbn,int price) {
		String sql = "update book set price = ? where isbn = ?";
		jdbcTemplate.update(sql, price,isbn);
	}
}
