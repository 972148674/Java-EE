package proxyFactoryBean;

import org.junit.Test;

/**
* @author blw
* @version 创建时间：2019年10月30日 上午11:51:53
* 类说明
*/
public class proxyFactorBeanDemo {
	
	@Test
	//动态代理
	public void demo(){
		OrderDao or = new OrderDaoImpl();
		
		OrderDaoProxyFactory factory = new OrderDaoProxyFactory(or);
		
		OrderDao proxy = factory.getUserServiceProxy();
		
		proxy.save();
	}
}
