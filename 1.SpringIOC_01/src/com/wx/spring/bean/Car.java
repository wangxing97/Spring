package com.wx.spring.bean;

public class Car {
	private String carName;
	private double carPrice;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carPrice=" + carPrice + "]";
	}
	public Car() {
		super();
		System.out.println("Car被创建了...");
	}
	
}
