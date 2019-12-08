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
		// ����xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// ��ȡ�Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ִ�в�ѯ
		User user = sqlSession.selectOne("userMapper.findUserById", 1);
		// System.out.println(user);
		// ��ѯȫ��
		List<User> list = sqlSession.selectList("userMapper.findUserAll");
		System.out.println(list.toString());
		// �ر�
		sqlSession.close();
	}

	@Test
	public void test02() throws IOException {
		// ����xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// ��ȡ�Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("tom");
		user.setId(30);
		int i = sqlSession.update("userMapper.updateUserById", user);
		// �ύ
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	SqlSessionFactory sqlSessionFactory ;
	@Before
	public void before() throws IOException {
		// ����xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// ��ȡ�Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test03() throws IOException {
		// �����Ự
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
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����Ҫ���ݵĲ�����װ��map��
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("name", "��");
		map.put("sex", "��");
		//��ȡ����userMapper�ӿڵĴ������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//����findUserMap
		List<User> list = userMapper.findUserMap(map);
		System.out.println(list);
		sqlSession.close();
	}
	
	
}
