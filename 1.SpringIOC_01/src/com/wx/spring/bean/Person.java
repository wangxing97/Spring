package com.wx.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private String lastName;
	private Integer age;
	private String eamil; 
	private String gender;
	private boolean flag;
	private Car car;
	private List<Book> books;
	private Map<String, Object> maps;
	private Properties  properties;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Person() {
		System.out.println("Person创建了...");
	}
	public Person(String lastName, Integer age, String eamil) {
		this.lastName = lastName;
		this.age = age;
		this.eamil = eamil;
		System.out.println("三个参数的构造器...age");
	}
	public Person(String lastName, String gender, String eamil) {
		this.lastName = lastName;
		this.gender = gender;
		this.eamil = eamil;
		System.out.println("三个参数的构造器...gender");
	}
	public Person(String lastName, Integer age, String eamil, String gender, boolean flag) {
		super();
		this.lastName = lastName;
		this.age = age;
		this.eamil = eamil;
		this.gender = gender;
		this.flag = flag;
		System.out.println("构造器被调用");
	}
	
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", eamil=" + eamil + ", gender=" + gender + ", flag="
				+ flag + ", car=" + car + ", books=" + books + ", maps=" + maps + ", properties=" + properties + "]";
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
