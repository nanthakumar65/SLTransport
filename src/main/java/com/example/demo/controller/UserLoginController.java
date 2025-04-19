package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseData;
import com.example.demo.payload.UserLoginData;
import com.example.demo.service.UserLoginService;

@RestController
@CrossOrigin
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;

	@PostMapping("/userLogin")
	public ResponseEntity<ResponseData> checkUserLogin(@RequestBody UserLoginData userLoginData) {
		ResponseData responseData = userLoginService.checkUserLogin(userLoginData.getUsername(),
				userLoginData.getPassword());
		if (!responseData.getStatus().equalsIgnoreCase("Failed")) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
