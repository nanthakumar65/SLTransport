package com.example.demo.data;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class AllDriversData {
	
	private Long id;

	private String driverName;
	
	private String fatherName;
	
	private String mobileNumber;
	
	private Date dob;
		
	private String aadharCard;
	
	private String licenseNumber;
	
	private String ntExpiry;
	
	private String tExpiry;
	
	private String accNumber;
	
	private String accHolderName;
	
	private String bankName;
	
	private String ifscCode;
	
	private String permanentAddress;
	
	private String temporaryAddress;
	
	private LocalDate createdDate;
	
	private String status;
	
	private Boolean driverStatus;

}
