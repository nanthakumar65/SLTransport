package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CountryCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CountryCodeId",unique = true,nullable = false)
	private Long countryCodeId;
	
	@Column(name="TeleCode")
	private String teleCode;
}
