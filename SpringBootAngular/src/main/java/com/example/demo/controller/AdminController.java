package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/authLogin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authUserNamePassword(@RequestBody LoginDto login){
		
		String result = loginService.authUser(login);
		
		System.out.println(" result "+result);
		return  ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto> registerUser(@RequestBody LoginDto login){

		
		System.out.println(" logindto "+login);
		
		
		ResponseDto response  = loginService.registerUser(login);
		
		return  ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
