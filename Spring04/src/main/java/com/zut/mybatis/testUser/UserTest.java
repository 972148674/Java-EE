package com.zut.mybatis.testUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zut.mybatis.mapper.UserMapper;
import com.zut.mybatis.pojo.User;

public class UserTest {

	@Test
	public void test() throws IOException {
		// 加载xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行查询
		User user = sqlSession.selectOne("userMapper.findUserById", 1);
		// System.out.println(user);
		// 查询全部
		List<User> list = sqlSession.selectList("userMapper.findUserAll");
		System.out.println(list.toString());
		// 关闭
		sqlSession.close();
	}

	@Test
	public void test02() throws IOException {
		// 加载xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("tom");
		user.setId(30);
		int i = sqlSession.update("userMapper.updateUserById", user);
		// 提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	SqlSessionFactory sqlSessionFactory ;
	@Before
	public void before() throws IOException {
		// 加载xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 获取会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test03() throws IOException {
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("tom");
		user.setId(30);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int i = userMapper.updateUserById(user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void test04() throws IOException {
		// 生产会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//将需要传递的参数封装到map中
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("name", "张");
		map.put("sex", "男");
		//获取基于userMapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用findUserMap
		List<User> list = userMapper.findUserMap(map);
		System.out.println(list);
		sqlSession.close();
	}
	
	
}
