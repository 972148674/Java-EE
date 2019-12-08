package com.zut.mybatis.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zut.mybatis.pojo.User;


public interface UserMapper {
	//�����û�
	User findUserById(int id);
	//�����û�
	int updateUserById(User user);
	//����û�
	int insertUser(User user);
	//ɾ���û�
	int deleteUser(User user);
}
