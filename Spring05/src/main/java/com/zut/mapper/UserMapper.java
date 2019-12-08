package com.zut.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zut.pojo.User;
import com.zut.pojo.User2;

public interface UserMapper {
	User findUserById(int id);
	List<User> findUserAll();
	List<User> findUserByBatch(List list);
	int updateUserById(User user);
	User findUserByName(String name);
	
	int updateUser(User user);
	
	int insertUser(User user);
	
	User findUserOrderOD(String name);
	
	
}

