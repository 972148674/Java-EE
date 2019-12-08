package com.zut.mybatis.testUser;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zut.mybatis.pojo.User;

/**
* @author blw
* @version 创建时间：2019年12月8日 上午9:43:15
* 类说明
*/
public class TestDemo {
	
	//查询用户
	@Test
	public void test1() throws IOException {
		// 加载xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行查询
		User user = sqlSession.selectOne("com.zut.mybatis.mapper.UserMapper.findUserById", 1);
		System.out.println(user);
		// 关闭
		sqlSession.close();
	}
	
	//添加用户
	@Test
	public void test2() throws IOException {
		// 加载xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user1 = new User();
		//user1.setId(5);
		user1.setUsername("张无忌");
		user1.setAddress("郑州");
		user1.setSex("男");
		user1.setBirthday(new Date(0));
		// 执行查询
		int i= sqlSession.update("com.zut.mybatis.mapper.UserMapper.insertUser", user1);
		System.out.println(i);
		// 关闭
		sqlSession.commit();
		sqlSession.close();
	}
	
	//更新用户
	@Test
	public void test3() throws IOException {
			// 加载xml
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// 获取会话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 生产会话
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 执行查询
			User user = new User();
			user.setUsername("tom");
			user.setId(1);
			int i = sqlSession.update("com.zut.mybatis.mapper.UserMapper.updateUserById", user);
			
			// 执行查询
			User user2 = sqlSession.selectOne("com.zut.mybatis.mapper.UserMapper.findUserById", 1);
			System.out.println(user2);
			// 关闭
			sqlSession.close();
		}
	
		//删除用户
		@Test
		public void test4() throws IOException {
			// 加载xml
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// 获取会话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 生产会话
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// 执行查询
			int row = sqlSession.delete("com.zut.mybatis.mapper.UserMapper.deleteUser", 3);
			// 关闭
			sqlSession.commit();
			sqlSession.close();
		}

}
