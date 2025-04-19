package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ResponseData;
import com.example.demo.model.Staff;
import com.example.demo.model.UserLogin;
import com.example.demo.payload.StaffPayload;
import com.example.demo.repository.StaffRepo;
import com.example.demo.repository.UserLoginRepository;
import com.example.demo.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	
	
	@Autowired
	private StaffRepo staffRepo;
	
	@Autowired
	private UserLoginRepository userLoingRepo;

	@Override
	public ResponseData saveStaffDetails(StaffPayload staffPayload) {
		
		ResponseData responseData = new ResponseData();
		
		Staff staffDetails=new Staff();
		staffDetails.setStaffName(staffPayload.getStaffName());
		staffDetails.setAadharNo(staffPayload.getAadharNo());
		staffDetails.setAddress(staffPayload.getAddress());
		staffDetails.setDateOfBirth(staffPayload.getDateOfBirth());
		staffDetails.setBankAccName(staffPayload.getBankAccName());
		staffDetails.setBankAccNo(staffPayload.getBankAccNo());
		staffDetails.setBloodGroup(staffPayload.getBloodGroup());
		staffDetails.setBranchName(staffPayload.getBranchName());
		staffDetails.setFatherName(staffPayload.getFatherName());
		staffDetails.setIfscCode(staffPayload.getIfscCode());
		staffDetails.setPhoneNo(staffPayload.getPhoneNo());
		staffDetails.setUserName(staffPayload.getUserName());
		staffDetails.setUserPwd(staffPayload.getUserPwd());
		
		Staff saveStaffDetails=staffRepo.save(staffDetails);
		
		UserLogin userLoginDetails=new UserLogin();
		userLoginDetails.setUserEmail(staffPayload.getUserName());
		userLoginDetails.setUserPsw(staffPayload.getUserPwd());
		
		UserLogin saveLoginDetails=	userLoingRepo.save(userLoginDetails);
		
		
		if(saveStaffDetails != null  && saveLoginDetails!=null) {
			responseData.setMessage("Successfully Saved");
			responseData.setResult(true);
			responseData.setStatus("Success");
		}
		return responseData;

	}

}
