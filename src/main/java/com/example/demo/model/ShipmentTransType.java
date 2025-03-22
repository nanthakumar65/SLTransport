package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ShipmentTransType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id",unique = true,nullable = false)
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="CreatedDate")
	private Date createdDate;
	
	@Column(name="LastmodifyDate")
	private Date lastmodifyDate;
}
