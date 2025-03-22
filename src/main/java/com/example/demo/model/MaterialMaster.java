package com.example.demo.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="MaterialMaster")
@Entity
public class MaterialMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaterialId",unique = true,nullable = false)
	private Long materialId;
	
	@Column(name="MaterialName")
	private String materialName;
	
	@Column(name="CreatedDate")
	@CreationTimestamp
	private Date createdDate;

}
