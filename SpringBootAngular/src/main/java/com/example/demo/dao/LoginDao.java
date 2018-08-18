package com.example.demo.dao;

import com.example.demo.entity.Login;

public interface LoginDao {

	public Integer verifyUser(Login login);
	
	public Integer registerUser(Login login);
}
