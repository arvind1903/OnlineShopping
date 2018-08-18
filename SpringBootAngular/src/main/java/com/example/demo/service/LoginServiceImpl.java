package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public String authUser(LoginDto loginDto) {
		Login  login = new Login();
		
		BeanUtils.copyProperties(loginDto, login);
		int result = loginDao.verifyUser(login);
		
		if(result>0){
			return "User Logged in successfully";
		}else
			return "failed to logged in";
	}

	
	@Override
	public ResponseDto registerUser(LoginDto loginDto) {
		Login  login = new Login();
		ResponseDto responseDto = new ResponseDto();
		
		BeanUtils.copyProperties(loginDto, login);
		
		login.setMobileNo(Long.parseLong(loginDto.getMobileNo()));
		
		Integer result = loginDao.registerUser(login);
		
		if(result!=null)
			responseDto.setSuccess("User Registered Successfully");
		else
			responseDto.setSuccess("User Failed to Register");
		return responseDto;
	}
}
