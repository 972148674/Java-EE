package proxyFactoryBean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
* @author blw
* @version 创建时间：2019年10月30日 下午12:43:06
* 类说明
*/
public class MyAspect implements MethodInterceptor {

	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("打开事务!");
		
		Object obj = mi.proceed(); 
		
		System.out.println("提交事务!");
		return obj;
	}

}
