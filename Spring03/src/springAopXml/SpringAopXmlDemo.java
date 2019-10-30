package springAopXml;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
* @author blw
* @version 创建时间：2019年10月29日 下午4:20:47
* 类说明 Spring的AOP的Xml开发
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/springAopXml/applicationContext.xml")
public class SpringAopXmlDemo {
	@Resource(name="orderDao")
	private OrderDao orderDao;
	
	@Test
	public void demo1(){
		orderDao.save();
		orderDao.find();
	}

}
