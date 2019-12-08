package com.zut.txAnnocation;
/**
* @author blw
* @version 创建时间：2019年12月7日 下午10:41:33
* 类说明
*/
public class Account {
	private Integer id;
	private String username;
	private Double balance;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", balance=" + balance + "]";
	}
	

}
