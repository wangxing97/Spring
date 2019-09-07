package com.wx.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wx.spring.impl.MyMathCalculator;
import com.wx.spring.inter.Calculator;
import com.wx.spring.proxy.CalculatorProxy;

class AOPTest01 {

	/*
	 * jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为它创建代理对象的；
	 * AOP底层就是动态代理；
	 */
	/*
	 * AOP专业术语
	 * 	 
	 */
	@Test
	void test() {
		Calculator calculator = new MyMathCalculator();
		calculator.add(1, 2);
		
		System.out.println("[=================]");
		//代理对象和被代理对象唯一能产生的关联就是实现了同一个接口
		Calculator proxy = CalculatorProxy.getProxy(calculator);
		proxy.add(2, 2);
		proxy.div(1, 5);
		proxy.mul(9, 9);
	}

}
