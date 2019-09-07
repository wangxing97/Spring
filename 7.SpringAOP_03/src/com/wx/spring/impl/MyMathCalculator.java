package com.wx.spring.impl;

import org.springframework.stereotype.Service;

import com.wx.spring.inter.Calculator;

public class MyMathCalculator /*implements Calculator*/{

	public int add(int a,double b) {
		return 0;
	}
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a+b;
	}

	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a-b;
	}

	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a*b;
	}

	public int div(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a/b;
	}

}
