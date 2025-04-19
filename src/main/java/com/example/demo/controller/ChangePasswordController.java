package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseData;
import com.example.demo.payload.ChangePasswordPayload;
import com.example.demo.payload.StaffPayload;
import com.example.demo.service.ChangePasswordService;

@RestController
@CrossOrigin
public class ChangePasswordController {
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	
	@PostMapping(value="/changePassword")
	public ResponseEntity<ResponseData> changePassword(@RequestBody ChangePasswordPayload changePaswwordPayload) {
		ResponseData changePasswordDetails = changePasswordService.changePassword(changePaswwordPayload);
		if (changePasswordDetails.getResult() == true) {
			return new ResponseEntity<>(changePasswordDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(changePasswordDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 

	

	
}
