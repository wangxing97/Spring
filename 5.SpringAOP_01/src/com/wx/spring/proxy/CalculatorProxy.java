package com.wx.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.wx.spring.inter.Calculator;
import com.wx.spring.utils.LogUtils;

public class CalculatorProxy {

	/*
	 *       ************反射***************
	 *       将类的各个组成部分封装为其他对象，就是反射机制
	 *       将 成员变量封装成Field变量
	 *       将构造方法封装成Constructor对象
	 *       将成员方法封装成Method对象
	 *       
	 *       1、好处
	 *       	1、可以在程序运行过程中，操作这些对象
	 *       	2、可以解耦，提高程序的可扩展性
	 *       
	 *       2、获取Class文件的三种方式
	 *       	1、Class.forName("全类名"); 将字节码文件加载进内存，返回Class对象。
	 *       	2、通过类名的属性class获取,类名.class
	 *       	3、对象.getClass
	 *       
	 *       具体去看MyJavaCode里的反射案例
	 */
	
	/*
	 * 为传入的参数对象创建一个动态代理对象
	 * 传入的是被代理对象
	 * 返回的是代理对象
	 */
	public static Calculator getProxy(final Calculator calculator) {
		// TODO Auto-generated method stub
		
		//方法执行器。帮助目标对象执行目标方法
		InvocationHandler h = new InvocationHandler() {
			
			/*
			 * proxy:代理对象，不要使用，给jdk使用的。
			 * method:当前将要执行的目标对象的方法
			 * args:调用时外界穿的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//利用反射执行目标方法
				//目标方法执行后的返回值
				Object result = null;
				try {
					LogUtils.startLog(method, args);
					result = method.invoke(calculator, args);
					LogUtils.returnLog(method, result);
				} catch (Exception e) {
					LogUtils.exceptionLog(method, e);
				}finally {
					System.out.println("["+method.getName()+"]方法最终执行完成");
				}
				//返回值必须return出去外界也可以拿得到
				return result;
			}
		};
		//接口
		Class<?>[] interfaces = calculator.getClass().getInterfaces();
		//类加载器,调用getClassLoader将字节码文件从硬盘加载到内存
		ClassLoader loader = calculator.getClass().getClassLoader();
		
		//Proxy为目标对象创建代理对象
		Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		return (Calculator) proxy;
	}
	
}
