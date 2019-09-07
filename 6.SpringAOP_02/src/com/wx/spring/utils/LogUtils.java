package com.wx.spring.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//告诉ioc这个是切面类
@Aspect
@Component
@Order(1)
public class LogUtils {

	/*
	 * try{
	 * 		@Before
	 * 		method.invoke(obj,args);
	 * 		@AfterReturning
	 * }catch(e){
	 * 		@AfterThrowing
	 * }finally{
	 * 		@After
	 * }
	 * 
	 * 5个通知注解
	 * @Before：在目标方法之前运行：前置通知
	 * @After：在目标方法结束之后：后置通知
	 * @AfterReturning：在目标方法正常返回之后：返回通知
	 * @AfterThrowing：在目标方法抛出异常之后运行：异常通知
	 * @Around：环绕：环绕通知
	 * 
	 * 抽取可重用的切入点表达式
	 * 1、随便声明一个没有实现的返回void的空方法
	 * 2、给方法上标注@Pointcut注解
	 */
	@Pointcut("execution(public int com.wx.spring.impl.MyMathCalculator.*(int, int))")
	public void testEmpty() {};
	
	//想在执行目标方法之前运行，写切入点表达式
	//execution(访问权限符  返回值类型 方法签名)
	@Before("testEmpty()")
	public static void startLog(JoinPoint joinPoint) {
		//joinPoint.getArgs()获取调用方法的所使用的参数
		//joinPoint.getSignature()获取方法全类名
		//joinPoint.getSignature().getName()获取方法名
		System.out.println("[LogUtils-前置]["+joinPoint.getSignature().getName()+"]方法正在执行，参数列表："+Arrays.asList(joinPoint.getArgs()));
	}
//	public static void startLog(Method method,Object[] args) {
//		System.out.println("["+method.getName()+"]方法正在执行，参数列表："+Arrays.asList(args));
//	}
	/*
	 * 细节2
	 * 切入点表达式的写法：
	 * 		固定格式：execution(访问权限符 返回值类型 方法全类名(参数表))
	 * 通配符：
	 * 		*：
	 * 			1)、匹配一个或多个字符
	 * 				@After("execution(public int com.wx.spring.impl.MyMath*.*(int, int))")
	 * 				匹配类名以MyMath开头的，任何方法
	 * 			2)、匹配任意一个参数
	 * 				@After("execution(public int com.wx.spring.impl.MyMath*.*(int, *))")
	 * 				匹配类名以MyMath开头的，任何方法，参数第一个int，第二个什么类型都可以
	 * 			3)、	只能匹配一层路径
	 * 			4)、权限位置不能写*，什么都不写就是任意权限
	 * 			
	 * 		..:
	 * 			1)、匹配任意多个参数，任意类型参数
	 * 				@After("execution(public int com.wx.spring.impl.MyMath*.*(..))")
	 * 				参数任意
	 * 			2)、匹配任意多层路径
	 * 				@Before("execution(public int com..MyMath*.*(*,*))")
	 * 				匹配com包下任意层下的以MyMath开头的类下的任意方法
	 * 		
	 * 		execution(* *.*(..))：任意包下的任意方法
	 * 
	 * 		&&、||、!
	 * 			1)、&&必须满足所有的表达式，就是与
	 * 			2)、||满足任意一个表达式，就是或
	 * 			3)、!只要不是这种表达式，就是非
	 */
	
	//告诉Spring这个result用来接收返回值
	@AfterReturning(value = "testEmpty()",returning = "result")
	public static void returnLog(JoinPoint joinPoint,Object result) {
		System.out.println("[LogUtils-返回]["+joinPoint.getSignature().getName()+"]方法执行完成，计算结果："+result);
	}
	
	/*
	 * 细节4
	 * 我们可以在通知方法运行的时候，拿到目标方法的详细信息
	 * 		1)、只需要为通知方法的参数列表上写一个参数
	 * 			JoinPoint joinPoint:封装了目标方法的详细信息
	 */
	@AfterThrowing(value = "testEmpty()",throwing = "e")
	public static void exceptionLog(JoinPoint joinPoint,Exception e) {
		System.out.println("[LogUtils-异常]["+joinPoint.getSignature().getName()+"]方法执行异常，错误信息："+e);
	}
	
	/*
	 * Spring对通知方法要求不严格，权限控制随便写，返回值随便写，没有要求。
	 * 唯一要求就是参数列表不能随便乱写
	 * 	通知方法是Spring利用反射机制调用的，每次方法调用得确定这个方法的参数表的值
	 * 	参数列表上的每一个参数Spring都得知道是什么，否则会报错
	 */
	@After("testEmpty()")
	public static void finalyLog(JoinPoint joinPoint) {
		System.out.println("[LogUtils-后置]["+joinPoint.getSignature().getName()+"]方法最终执行完成");
	}

	/*
	 * @Around：环绕通知：是Spring中强大的通知；
	 * @Around：环绕通知：动态代理；
	 * try{
	 * 		前置通知
	 * 		method.invoke(obj,args);
	 * 		返回通知
	 * }catch(e){
	 * 		异常通知
	 * }finally{
	 * 		后置通知
	 * }
	 * 
	 * 四合一通知就是环绕通知；
	 * 	1、环绕通知中有一个参数：ProceedingJoinPoint pjp
	 * 	2、环绕通知优先于普通通知先执行，执行顺序
	 *  [普通前置]
	 *  {
	 *  	try{
	 *  		环绕前置
	 *  		目标方法执行
	 *  		环绕返回
	 *		}catch(e){
	 *			环绕异常
	 *		}finally{
	 *			环绕后置
	 *		}  	
	 *  }
	 *  [普通后置]
	 *  [普通方法返回/方法异常]
	 *  
	 *  新的顺序：前置随机(环绕前置==>普通前置)==>目标方法执行==>环绕正常返回/出现异常==>环绕后置==>普通正常返回/普通异常==>普通后置
	 */
	@Around("testEmpty()")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		//利用反射调用目标方法  == method.invoke(obj,args)
		
		Object[] args = pjp.getArgs();
		Object proceed = null;
		try {
			System.out.println("环绕前置通知..");
			proceed = pjp.proceed(args);
			System.out.println("环绕返回通知..");
		} catch (Exception e) {
			//为了让外界感知到异常，需要将异常抛出去
			System.out.println("环绕异常通知..");
			throw new RuntimeException(e);
		}finally {
			System.out.println("环绕后置通知..");
		}
		//反射调用后的返回值也一定返回出去
		return proceed;
	}
}
