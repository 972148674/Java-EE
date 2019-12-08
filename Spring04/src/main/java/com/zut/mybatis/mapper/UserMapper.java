package com.zut.mybatis.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zut.mybatis.pojo.User;


public interface UserMapper {
	//查找用户
	User findUserById(int id);
	//更新用户
	int updateUserById(User user);
	//添加用户
	int insertUser(User user);
	//删除用户
	int deleteUser(User user);
}
