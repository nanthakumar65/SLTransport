package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vendors {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
	private Long id;
	
	@Column(name = "CustomerId")
	private Long customerId;
	
	@Column(name = "CustomerName")
	private String customerName;
	
	@Column(name = "SiteName")
	private String siteName;
	
	@Column(name = "ContactPersonName")
	private String contactPersonName;
	
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	@Column(name = "GstnNumber")
	private String gstnNumber;
	
	@Column(name = "AccNumber")
	private String accNumber;
	
	@Column(name = "AccHolderName")
	private String accHolderName;
	
	@Column(name = "BankName")
	private String bankName;
	
	@Column(name = "IfscCode")
	private String ifscCode;
	
	@Column(name = "Address")
	private String address;
}
