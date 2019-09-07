package com.wx.spring.bean;

public class Book {
	private String bookName;
	private String author;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + "]";
	}
	public Book() {
		super();
		System.out.println("Book被创建了...");
	}
	
}
