package com.example.demo.service;

import com.example.demo.data.ProfileData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.ProfilePayload;

public interface ProfileService {

	public ResponseData saveProfile(ProfilePayload profilePayload);

	public ProfileData getProfileDetails();

}
