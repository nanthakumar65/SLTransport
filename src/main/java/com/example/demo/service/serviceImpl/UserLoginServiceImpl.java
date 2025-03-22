package com.example.demo.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ResponseData;
import com.example.demo.model.UserLogin;
import com.example.demo.repository.UserLoginRepository;
import com.example.demo.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserLoginRepository userLoginRepo;

	@Override
	public ResponseData checkUserLogin(String userName, String userPsw) {
		ResponseData responseData = new ResponseData();
		Optional<UserLogin> userLogin = userLoginRepo.findByUserEmailAndUserPsw(userName, userPsw);
		if (userLogin.isPresent()) {
			responseData.setResult(true);
			responseData.setStatus("Success");
			responseData.setMessage("Login Successfully");
		}else {
			responseData.setMessage("Login Failed");
		}
		return responseData;
	}
	

}
