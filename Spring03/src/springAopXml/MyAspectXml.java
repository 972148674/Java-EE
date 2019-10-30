package springAopXml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
* @author blw
* @version 创建时间：2019年10月30日 上午9:23:36
* 类说明
*/
public class MyAspectXml {

	// 前置增强
	public void before(){
	System.out.println("前置增强");
	}
	
	//后置增强
	public void after(){
		System.out.println("后置增强");
	}
	
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知之前的部分!!");
		Object proceed = pjp.proceed();//调用目标方法
		System.out.println("这是环绕通知之后的部分!!");
		return proceed;
	}
	
	//异常通知
	public void afterException(){
		System.out.println("出事啦!出现异常了!");
	}
	
	
}
