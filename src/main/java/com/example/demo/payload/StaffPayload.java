package com.example.demo.payload;

import java.util.Date;


import lombok.Data;

@Data
public class StaffPayload {
	
	
    private String staffName;

    private String fatherName;

    private String address;

    private Long aadharNo;

    private String phoneNo;

    private Date dateOfBirth;

    private String bloodGroup;

    private String bankAccName;
    
    private String bankAccNo;

    private String ifscCode;

    private String branchName;
    
    private String userName;
    
    private String userPwd;


}
