package com.example.demo.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Drivers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DriverId")
	private Long driverId;
	
	@Column(name = "Age")
	private Long age;
	
	@Column(name="Name")
	private String name;
	
	@Column(name = "FatherName")	
	private String fatherName;
	
	@Column(name = "PermanentAddress")
	private String permanentAddress;
	
	@Column(name = "TemporaryAddress")
	private String temporaryAddress;
	
	@Column(name = "MobileNumber")
	private String mobileNumber;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "LicenseNumber")
	private String licenseNumber; 
	
	@Column(name = "LicenseDuration")
	private Date licenseDuration;
	
	@Column(name = "NTExpiry")
	private String ntExpiry ;
	
	@Column(name = "TExpiry")
	private String tExpiry;
	
	@Column(name = "AccNumber")
	private String accNumber;
	
	@Column(name = "BankName")
	private String bankName;
	
	@Column(name = "IFSCCode")
	private String ifscCode;
	
	@Column(name = "LicenseStatus")
	private String licenseStatus; 
	
	@Column(name = "AadharCardNo")
	private String aadharCardNo;
	
	@CreationTimestamp
	@Column(name = "CreatedDate")
	private Date createdDate;
	
	@CreationTimestamp
	@Column(name = "LastModifyDate")
	private Date lastModifyDate;
	
	@Column(name = "AccHolderName")
	private String accHolderName;
	
	
	@Column(name="Active")
	private Boolean active; 
}
