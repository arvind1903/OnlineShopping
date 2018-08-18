package com.example.demo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Login;
import com.example.demo.repository.LoginRepository;

@Component
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public Integer verifyUser(Login login) {
		/*
		String query = "select userId from users where UserName=? and password=?";
		
		List<String> resultList = jdbcTemplate.query(query, new Object[]{login.getUserName(),login.getPassword()},new RowMapper(){

			@Override
			public String mapRow(ResultSet resultSet, int arg1) throws SQLException {
				
				return resultSet.getString(1);
			}
				
		});
		
		
		System.out.println(" resultset size "+resultList.size());
		if(resultList.size()>0){
			return 1;
		}else{
			return 0;
		}*/
		
		System.out.println(" login details "+login);
		
		Integer value = loginRepository.findByUserNameAndPassword(login.getUserName(),login.getPassword());
		
		System.out.println(" result "+value);
		
		return value;
	}

	
	@Override
	public Integer registerUser(Login login) {
		
		
		System.out.println(" register user "+login);
		
		Login loginRes = loginRepository.save(login);
		
		if(loginRes!=null)
			return 1;
		else 
			return 0;
	}
}
