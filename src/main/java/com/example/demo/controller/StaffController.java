package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseData;
import com.example.demo.payload.StaffPayload;
import com.example.demo.service.StaffService;

@RestController
@CrossOrigin
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping(value="/saveStaffDetails")
	public ResponseEntity<ResponseData> saveStaffDetails(@RequestBody StaffPayload StaffPayload) {
		ResponseData saveStaffDetails = staffService.saveStaffDetails(StaffPayload);
		if (saveStaffDetails.getResult() == true) {
			return new ResponseEntity<>(saveStaffDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(saveStaffDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 

}
