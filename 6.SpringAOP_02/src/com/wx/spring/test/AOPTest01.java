package com.wx.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.spring.impl.MyMathCalculator;
import com.wx.spring.inter.Calculator;

class AOPTest01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	/*
	 * 细节3
	 * 通知方法的执行顺序
	 * 
	 * 正常执行：@Before(前置通知)===>@After(后置通知)===>AfterReturning(正常返回)
	 * 异常执行：@Before(前置通知)===>@After(后置通知)===>AfterThrowing(方法异常)
	 * 
	 * 多个切面，先进后出 
	 */
	
	/*
	 * AOP使用场景
	 * 		1)、AOP加日志保存到数据库
	 * 		2)、AOP做权限验证
	 * 		3)、AOP做安全检查
	 * 		4)、AOP做事务控制
	 */
	@Test
	void test03() {
		MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
		bean.add(1, 2);
		//bean.div(1, 0);
	}
	
	@Test
	void test02() {
		MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
		bean.add(1, 0.3);
		System.out.println(bean.getClass());
	}
	
	@Test
	void test() {
		//细节1
		//1、从ioc容器中拿到目标对象，注意：如果想用类型查找，一定要找他的接口类型
		//Calculator bean2 = (Calculator) ioc.getBean("myMathCalculator");
		//System.out.println(bean2.getClass());
		Calculator bean = ioc.getBean(Calculator.class);
		bean.add(3, 4);
		/*
		 * com.wx.spring.impl.MyMathCalculator@24569dba
		   class com.sun.proxy.$Proxy13
		   AOP的底层就是动态代理，容器中保存的就是代理对象
		 */
		System.out.println(bean);
		System.out.println(bean.getClass());
		//没有接口也可以获得代理对象，cglib会自动获取。获取类直接获取MyMathCalculator类即可
	}

}
