package proxyFactoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author blw
* @version 创建时间：2019年10月30日 下午1:05:41
* 类说明
*/
public class ProxyFactoryBeanXmlDemo {
	
	public static void main(String[] args) {
		String xmlPath = "proxyFactoryBean/applicationContext.xml";
		ApplicationContext  applicationContext= new ClassPathXmlApplicationContext(xmlPath);
		
		OrderDao orderDao = (OrderDao)applicationContext.getBean("orderDaoProxy");
		
		//执行方法
		orderDao.save();
	}

}
