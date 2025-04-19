package com.example.demo.payload;

import lombok.Data;

@Data
public class ChangePasswordPayload {
	
	private String userName;
	
	private String oldPassword;
	
	private String newPassword;
	
	private String confirmPassword;
	

}
