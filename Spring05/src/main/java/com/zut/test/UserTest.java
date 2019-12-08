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
		// ����idִ�в�ѯ
		User user = sqlSession.selectOne("com.zut.mapper.UserMapper.findUserById", 1);
		System.out.println(user);

		// ����id��ѯ
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		List<User> listUser = sqlSession.selectList("com.zut.mapper.UserMapper.findUserByBatch", list);
		System.out.println(listUser.toString());

		// ģ����ѯ
		List<User> users = sqlSession.selectList("com.zut.mapper.UserMapper.findUserByName", "��");
		System.out.println(users.toString());
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test2() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ��̬�޸��û���Ϣ
		User user = new User();
		user.setId(1);
		user.setSex("Ů");
		int rows = sqlSession.update("com.zut.mapper.UserMapper.updateUser", user);
		if (rows > 0) {
			System.out.println("��ɹ����޸���" + rows + "�����ݣ�");
		} else {
			System.out.println("�޸�ʧ��");
		}

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test3() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ��̬����û���Ϣ
		User user = new User();
		user.setId(3);
		user.setUsername("����");
		user.setSex("Ů");
		user.setAddress("�Ϻ�");
		int rows = sqlSession.update("com.zut.mapper.UserMapper.insertUserByAll", user);
		if (rows > 0) {
			System.out.println("��ɹ��������" + rows + "�����ݣ�");
		} else {
			System.out.println("���ʧ��");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	//���ݶ�����Ų�ѯ�û���Ϣ
	//�����û�����ѯ�û��Ķ�����Ϣ
	//�����û�����ѯ�û��������������Ʒ��Ϣ
	@Test
	public void test4() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//���ݶ�����Ų�ѯ�û���Ϣ
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		Orders orders = ordersMapper.findOrderUserByNumber("99");
		User2 user2 = orders.getUser2();
		System.out.println(user2.toString());
		
		//�����û�����ѯ�û��Ķ�����Ϣ
		User2 user3= ordersMapper.findOrderUserByName("����");
		System.out.println(user3.toString());
		
		//�����û�����ѯ�û��������������Ʒ��Ϣ
		User2 user4= ordersMapper.findOrderUserOrderDetailByName("����");
		System.out.println(user4.toString());
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	


}
