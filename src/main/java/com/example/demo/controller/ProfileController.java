package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ProfileData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.ProfilePayload;
import com.example.demo.service.ProfileService;

@RestController
@CrossOrigin
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/saveProfile")
	public ResponseEntity<ResponseData> saveProfile(@RequestBody ProfilePayload profilePayload) {
		ResponseData responseData = profileService.saveProfile(profilePayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getProfileDetails")
	public ResponseEntity<ProfileData> getProfileDetails() {
		ProfileData profileData = profileService.getProfileDetails();
		if (profileData != null) {
			return new ResponseEntity<>(profileData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(profileData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
