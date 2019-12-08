package com.zut.txAnnocation;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zut.txAnnocation.AccountDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/zut/txAnnocation/springtx.xml")
public class TestTx {
	
	@Resource
	private AccountDao accountDao;
	
	@Test
	public void test01() {
		accountDao.transfer("张三","李四",1000.0);
		System.out.println("转账成功！");
	}
	
}
