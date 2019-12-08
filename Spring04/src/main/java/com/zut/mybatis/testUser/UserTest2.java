package com.zut.mybatis.testUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zut.mapper.OrdersMapper;
import com.zut.mapper.UserMapper;
import com.zut.pojo.Orders;
import com.zut.pojo.User;
import com.zut.pojo.User2;
import com.zut.pojo.UserExp;

public class UserTest2 {

	
	SqlSessionFactory sqlSessionFactory ;
	@Before
	public void before() throws IOException {
		// 加载xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test//测试动态sql查询
	public void test01() throws IOException {
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		//user.setUsername("张");
		//user.setId(30);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByExample(user);
		System.out.println(list);
		sqlSession.close();
		
	}
	
	@Test//测试动态sql添加
	public void test02() throws IOException {
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("歆宸");
		user.setId(46);
		user.setSex("女");
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUserByExample(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test//批量查询
	public void test03() throws IOException {
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		ArrayList<Integer> list = new ArrayList<Integer>();
		//list.add(1);
		list.add(30);
		list.add(41);
		List<User> list2 = userMapper.findUserByBatch(list);
		//System.out.println(list2);
		
		//批量删除
		UserExp userExp = new UserExp();
		userExp.setIds(list);
		userMapper.deleteUserBatch(userExp);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//一对多根据用户名查询用户信息以及订单信息以及订单明细
	@Test
	public void test04() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user= userMapper.findUserOrderOD("李四");
		System.out.println(user.toString());
		sqlSession.close();
	}
	//根据用户名查询商品信息
	@Test
	public void test05() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserOrderODItems("李四");
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void test06() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		Orders orders = ordersMapper.ordersUserQTQ("1000010");
		User user = orders.getUser();
		sqlSession.close();
	}
	//一级缓存测试
	@Test
	public void test07() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession sqlSession2 = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		//执行下提交
//		user.setUsername("晨晨");
//		user.setId(48);
//		userMapper.insertUserByExample(user);
		//一旦执行提交一级缓存清空
		//sqlSession.commit();
		//再查询
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		sqlSession.close();
	}
	
	
	
	
	
	
	
}
