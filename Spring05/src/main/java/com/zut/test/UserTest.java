package com.zut.test;

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

public class UserTest {

	@Test
	public void test1() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 单个id执行查询
		User user = sqlSession.selectOne("com.zut.mapper.UserMapper.findUserById", 1);
		System.out.println(user);

		// 批量id查询
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		List<User> listUser = sqlSession.selectList("com.zut.mapper.UserMapper.findUserByBatch", list);
		System.out.println(listUser.toString());

		// 模糊查询
		List<User> users = sqlSession.selectList("com.zut.mapper.UserMapper.findUserByName", "张");
		System.out.println(users.toString());
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test2() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 动态修改用户信息
		User user = new User();
		user.setId(1);
		user.setSex("女");
		int rows = sqlSession.update("com.zut.mapper.UserMapper.updateUser", user);
		if (rows > 0) {
			System.out.println("你成功的修改了" + rows + "条数据！");
		} else {
			System.out.println("修改失败");
		}

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test3() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 动态添加用户信息
		User user = new User();
		user.setId(3);
		user.setUsername("王五");
		user.setSex("女");
		user.setAddress("上海");
		int rows = sqlSession.update("com.zut.mapper.UserMapper.insertUserByAll", user);
		if (rows > 0) {
			System.out.println("你成功的添加了" + rows + "条数据！");
		} else {
			System.out.println("添加失败");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	//根据订单编号查询用户信息
	//根据用户名查询用户的订单信息
	//根据用户名查询用户所购买的所有商品信息
	@Test
	public void test4() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//根据订单编号查询用户信息
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		Orders orders = ordersMapper.findOrderUserByNumber("99");
		User2 user2 = orders.getUser2();
		System.out.println(user2.toString());
		
		//根据用户名查询用户的订单信息
		User2 user3= ordersMapper.findOrderUserByName("李四");
		System.out.println(user3.toString());
		
		//根据用户名查询用户所购买的所有商品信息
		User2 user4= ordersMapper.findOrderUserOrderDetailByName("李四");
		System.out.println(user4.toString());
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	


}
