package com.zut.pojo;

import java.util.Date;
import java.util.List;

/**
* @author blw
* @version 创建时间：2019年12月5日 下午9:12:45
* 类说明
*/
public class User2 {
	
	private Integer id;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	//一对多 
	private List<Orders> ordersList;
	
	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + ", ordersList=" + ordersList + "]";
	}

}
