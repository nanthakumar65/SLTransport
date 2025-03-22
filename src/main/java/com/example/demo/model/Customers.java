package com.example.demo.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CustomerId",unique = true,nullable = false)
	private Long customerId;
	
	@Column(name="CustomerName")
	private String customerName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="TeleCode")
	private String teleCode;
	
	@Column(name="Phone")
	private String phone;
	
	@CreationTimestamp
	@Column(name="CreatedDate")
	private Date createdDate;
	
	@CreationTimestamp
	@Column(name="LastmodifyDate")
	private Date lastmodifyDate;
	
	@Column(name="GST")
	private String gst;
	
	@Column(name="Country")
	private String country;
}
