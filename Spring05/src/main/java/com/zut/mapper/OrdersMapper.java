package com.zut.mapper;


import com.zut.pojo.Orders;
import com.zut.pojo.User2;

public interface OrdersMapper { 
	// 使用嵌套查询实现根据订单编号查询用户信息 
	Orders findOrderUserByNumber(String number);
	//使用嵌套结果实现根据订单编号查询用户信息
	Orders ordersUserQTQ(String number);
	
	//根据用户名查询用户的订单信息
	User2 findOrderUserByName(String name);
	
	//根据用户名查询用户所购买的所有商品信息
	User2 findOrderUserOrderDetailByName(String name);
	
}
