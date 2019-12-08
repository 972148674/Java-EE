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
* @version ����ʱ�䣺2019��12��8�� ����9:43:15
* ��˵��
*/
public class TestDemo {
	
	//��ѯ�û�
	@Test
	public void test1() throws IOException {
		// ����xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// ��ȡ�Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ִ�в�ѯ
		User user = sqlSession.selectOne("com.zut.mybatis.mapper.UserMapper.findUserById", 1);
		System.out.println(user);
		// �ر�
		sqlSession.close();
	}
	
	//����û�
	@Test
	public void test2() throws IOException {
		// ����xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// ��ȡ�Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user1 = new User();
		//user1.setId(5);
		user1.setUsername("���޼�");
		user1.setAddress("֣��");
		user1.setSex("��");
		user1.setBirthday(new Date(0));
		// ִ�в�ѯ
		int i= sqlSession.update("com.zut.mybatis.mapper.UserMapper.insertUser", user1);
		System.out.println(i);
		// �ر�
		sqlSession.commit();
		sqlSession.close();
	}
	
	//�����û�
	@Test
	public void test3() throws IOException {
			// ����xml
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// ��ȡ�Ự����
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// �����Ự
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// ִ�в�ѯ
			User user = new User();
			user.setUsername("tom");
			user.setId(1);
			int i = sqlSession.update("com.zut.mybatis.mapper.UserMapper.updateUserById", user);
			
			// ִ�в�ѯ
			User user2 = sqlSession.selectOne("com.zut.mybatis.mapper.UserMapper.findUserById", 1);
			System.out.println(user2);
			// �ر�
			sqlSession.close();
		}
	
		//ɾ���û�
		@Test
		public void test4() throws IOException {
			// ����xml
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// ��ȡ�Ự����
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// �����Ự
			SqlSession sqlSession = sqlSessionFactory.openSession();
			// ִ�в�ѯ
			int row = sqlSession.delete("com.zut.mybatis.mapper.UserMapper.deleteUser", 3);
			// �ر�
			sqlSession.commit();
			sqlSession.close();
		}

}
