package com.example.demo.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserLginId")
	private Long userLginId;
	
	@Column(name = "UserEmail")
	private String userEmail;
	
	@Column(name = "UserPsw")
	private String userPsw;
	
	@CreationTimestamp
	@Column(name = "CreatedDate")
	private String createdDate;
	
	
}
