package com.example.demo.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ResponseData;
import com.example.demo.model.Staff;
import com.example.demo.model.UserLogin;
import com.example.demo.payload.ChangePasswordPayload;
import com.example.demo.repository.StaffRepo;
import com.example.demo.repository.UserLoginRepository;
import com.example.demo.service.ChangePasswordService;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService{
	
	
	
	@Autowired
	private UserLoginRepository userLoginRepo;

	@Override
	public ResponseData changePassword(ChangePasswordPayload changePasswordPayload) {
		ResponseData responseData = new ResponseData();

		Optional<UserLogin> userLoginDetails = userLoginRepo.findByUserEmail(changePasswordPayload.getUserName());

		if (!userLoginDetails.isPresent()) {
			responseData.setMessage("UserName Not Found");
			return responseData;
		}

		UserLogin existinguserLoginDetails = userLoginDetails.get();

		if (!existinguserLoginDetails.getUserPsw().equals(changePasswordPayload.getOldPassword())) {
			responseData.setMessage("Please Provide valid old password");
			return responseData;
		}

		if (!changePasswordPayload.getNewPassword().equals(changePasswordPayload.getConfirmPassword())) {
			responseData.setMessage("New Password and Confirm Password Mismatch...");
			return responseData;
		}
		existinguserLoginDetails.setUserPsw(changePasswordPayload.getNewPassword());
		userLoginRepo.save(existinguserLoginDetails);

		responseData.setResult(true);
		responseData.setStatus("Success");
		responseData.setMessage("Password Changed Successfully");

		return responseData;
	}

}
