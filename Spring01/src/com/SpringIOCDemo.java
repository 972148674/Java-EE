package com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author blw
* @version 创建时间：2019年10月14日 下午5:16:12
* 类说明
*/
public class SpringIOCDemo {

	@Test
	public void demo() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		userDao.save();
	}
}
