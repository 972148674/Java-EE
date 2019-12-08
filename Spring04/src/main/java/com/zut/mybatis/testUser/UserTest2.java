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
		// ����xml
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// ��ȡ�Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test//���Զ�̬sql��ѯ
	public void test01() throws IOException {
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		//user.setUsername("��");
		//user.setId(30);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByExample(user);
		System.out.println(list);
		sqlSession.close();
		
	}
	
	@Test//���Զ�̬sql���
	public void test02() throws IOException {
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("��");
		user.setId(46);
		user.setSex("Ů");
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUserByExample(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test//������ѯ
	public void test03() throws IOException {
		// �����Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		ArrayList<Integer> list = new ArrayList<Integer>();
		//list.add(1);
		list.add(30);
		list.add(41);
		List<User> list2 = userMapper.findUserByBatch(list);
		//System.out.println(list2);
		
		//����ɾ��
		UserExp userExp = new UserExp();
		userExp.setIds(list);
		userMapper.deleteUserBatch(userExp);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//һ�Զ�����û�����ѯ�û���Ϣ�Լ�������Ϣ�Լ�������ϸ
	@Test
	public void test04() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user= userMapper.findUserOrderOD("����");
		System.out.println(user.toString());
		sqlSession.close();
	}
	//�����û�����ѯ��Ʒ��Ϣ
	@Test
	public void test05() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserOrderODItems("����");
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
	//һ���������
	@Test
	public void test07() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession sqlSession2 = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		//ִ�����ύ
//		user.setUsername("����");
//		user.setId(48);
//		userMapper.insertUserByExample(user);
		//һ��ִ���ύһ���������
		//sqlSession.commit();
		//�ٲ�ѯ
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		sqlSession.close();
	}
	
	
	
	
	
	
	
}
