package com.zut.txAnnocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void transfer(String name1, String name2, double d) {
		String sql1 = "update account set balance=balance-?"+" where username=?";
		String sql2 = "update account set balance=balance+?"+" where username=?";
		jdbcTemplate.update(sql1,d,name1);
		jdbcTemplate.update(sql2,d,name2);
	}

}
