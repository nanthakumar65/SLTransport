package com.example.demo.service;

import com.example.demo.data.ResponseData;

public interface UserLoginService {

	public ResponseData checkUserLogin(String userName, String userPsw);
}
