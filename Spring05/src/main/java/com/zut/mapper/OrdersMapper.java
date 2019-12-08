package com.zut.mapper;


import com.zut.pojo.Orders;
import com.zut.pojo.User2;

public interface OrdersMapper { 
	// ʹ��Ƕ�ײ�ѯʵ�ָ��ݶ�����Ų�ѯ�û���Ϣ 
	Orders findOrderUserByNumber(String number);
	//ʹ��Ƕ�׽��ʵ�ָ��ݶ�����Ų�ѯ�û���Ϣ
	Orders ordersUserQTQ(String number);
	
	//�����û�����ѯ�û��Ķ�����Ϣ
	User2 findOrderUserByName(String name);
	
	//�����û�����ѯ�û��������������Ʒ��Ϣ
	User2 findOrderUserOrderDetailByName(String name);
	
}
