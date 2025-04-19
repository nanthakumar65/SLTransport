package com.example.demo.payload;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DriverExpensePayload {

	private Long driverId;
	
	private Double advance;
	
	private Double driverExpense;
	
	private Double vehicleExpense;
	
	private LocalDate expenseDate;
	
	private String description;
	
}
