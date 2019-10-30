package proxyFactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
* @author blw
* @version 创建时间：2019年10月30日 上午11:55:25
* 类说明
*/

public class OrderDaoProxyFactory implements InvocationHandler{

	public OrderDaoProxyFactory(OrderDao or) {
		super();
		this.or = or;
	}

	private OrderDao or;
	
	public OrderDao getUserServiceProxy() {
		// 生成动态代理
		OrderDao proxy = (OrderDao) Proxy.newProxyInstance(OrderDaoProxyFactory.class.getClassLoader(),
				OrderDaoImpl.class.getInterfaces(), this);
		// 返回
		return proxy;

	}

	public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
		System.out.println("打开事务!");
		Object invoke = method.invoke(or, arg2); 
		System.out.println("提交事务!");
		return invoke;
	}
}
