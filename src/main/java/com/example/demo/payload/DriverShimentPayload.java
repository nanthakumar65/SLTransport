package com.example.demo.payload;

import java.util.Date;

import lombok.Data;

@Data
public class DriverShimentPayload {

	private Long customerId;
	
	private Long vehicleId;
	
	private Long driverId;
	
	private String source;
	
	private String destination;
	
	private String driverExpenseType;
	
	private String driverExpense;
	
	private Long shipmentTypeId;
	
	private String shipmentQuantity;
	
	private Long shipmentTransTypeId;
	
	private String shiftType;
	
	private String inDriver;
	
	
	private String secondDriver;
	
	private String ShipmentDate;
}
