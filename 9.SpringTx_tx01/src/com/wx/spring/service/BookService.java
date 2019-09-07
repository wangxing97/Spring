package com.wx.spring.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.wx.spring.dao.BookDao;

@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	/*
	 * 结账：传入哪个用户买了哪本书
	 */
	
	/*
	 * 事务细节
	 * isolation-Isolation:事务的隔离级别
	 * propagation-Propagation:事务的传播行为***
	 * 
	 * readOnly-boolean：设置事务为只读事务
	 * 					 可以进行事务优化，只可读，加快速度。
	 * timeout-int:事务超过指定时长后自动回滚
	 * 
	 * noRollbackFor-Class[]:哪些异常事务可以不回滚
	 * noRollbackForClassName-String[]:全类名
	 * rollbackFor-Class[]：哪些异常事务回滚
	 * rollbackForClassName-String[]:全类名
	 */
	/*
	 * 异常分类:
	 * 		运行时异常，可以不用处理，默认都回滚
	 * 		编译时异常，必须try-catch或者throws，默认不回滚
	 */
	//@Transactional(timeout = 3/*,readOnly = true *//*,noRollbackFor = {ArithmeticException.class}*/)
	@Transactional(noRollbackForClassName = {"java.lang.ArithmeticException"})
	public void checkout(String username,String isbn) {
		bookDao.updateStock(isbn);
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		int price = bookDao.getBookPrice(isbn);
		bookDao.updateBalance(username, price);
		int a = 10/0;
	}
	
	@Transactional(rollbackFor = {FileNotFoundException.class})
	public void checkout1(String username,String isbn) throws FileNotFoundException {
		bookDao.updateStock(isbn);
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		int price = bookDao.getBookPrice(isbn);
		bookDao.updateBalance(username, price);
		new FileInputStream("D:\\hhhh");
	}
	
	@Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
	public int getPrice(String isbn) {
		return bookDao.getBookPrice(isbn);
	}
}
