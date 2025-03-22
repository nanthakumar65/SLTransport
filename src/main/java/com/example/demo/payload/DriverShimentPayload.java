package com.example.demo.payload;

import java.util.Date;

import lombok.Data;

@Data
public class DriverShimentPayload {

	private String name;
	
	private String vehicleNumber;
	
	private String source;
	
	private String destination;
	
	private String driverExpenseType;
	
	private String driverExpense;
	
	private String shipmentType;
	
	private String shipmentQuantity;
	
	private String shipmentTransType;
	
	private String shiftType;
	
	private String inDriver;
	
	private Date shipmentDate;
}
