package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="DriverExpense")
@Entity
public class DriverExpense {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long driverExpenseId;
	
	@Column(name="DriverName")
	private String driverName;
	
	@Column(name="Advance")
	private Double advance;
	
	@Column(name="DriverExpense")
	private Double driverExpense;
	
	@Column(name="VehicleExpense")
	private Double vehicleExpense;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="DriverId")
	private Long driverId;
	
	@Column(name="ExpenseDate")
	private LocalDate expenseDate;
	
	@Column(name="CreatedDate")
	private LocalDate createdDate;
}
