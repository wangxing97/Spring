package com.wx.spring.impl;

import org.springframework.stereotype.Service;

import com.wx.spring.inter.Calculator;

@Service
public class MyMathCalculator /*implements Calculator*/{

	public int add(int a,double b) {
		return 0;
	}
	//@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a+b;
	}

	//@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a-b;
	}

	//@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a*b;
	}

	//@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("方法内部执行...");
		return a/b;
	}

}
