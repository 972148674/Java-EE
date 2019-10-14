package com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author blw
* @version ����ʱ�䣺2019��10��14�� ����5:16:12
* ��˵��
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
