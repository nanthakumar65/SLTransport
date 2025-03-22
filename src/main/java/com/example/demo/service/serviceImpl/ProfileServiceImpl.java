package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ProfileData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.Profile;
import com.example.demo.payload.ProfilePayload;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository ProfileRepo;
	
	
	@Override
	public ResponseData saveProfile(ProfilePayload profilePayload) {
		ResponseData responseData = new ResponseData();
		Profile profile = new Profile();
		profile.setName(profilePayload.getName());
		profile.setEmail(profilePayload.getEmail());
		profile.setPhone(profilePayload.getPhone());
		profile.setAddress(profilePayload.getAddress());
		Profile saveProfile = ProfileRepo.save(profile);
		if(saveProfile != null) {
			responseData.setResult(true);	
			responseData.setMessage("Successfully Saved");
			responseData.setStatus("Success");
		}else {
			responseData.setMessage("Failed");
		}
		return responseData;
	}


	@Override
	public ProfileData getProfileDetails() {

		Profile profile = ProfileRepo.findAll().get(0);
		if (profile != null) {
			ProfileData profileData = new ProfileData();
			profileData.setName(profile.getName());
			profileData.setEmail(profile.getEmail());
			profileData.setPhone(profile.getPhone());
			profileData.setAddress(profile.getAddress());
			return profileData;
		}
		return null;
	}

}
