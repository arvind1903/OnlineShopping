package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Login;

public interface LoginService {

	
	public String authUser(LoginDto login);
	
	public ResponseDto registerUser(LoginDto login);  
}
