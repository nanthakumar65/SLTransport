package com.example.demo.data;

import java.util.Date;

import lombok.Data;

@Data 
public class DriverShipmentData {
	
	private Long driverShipmentId;
	
    private Long customerId;
    
    private String customerName;
	
	private Long vehicleId;
	
	private String vehicleNumber;
	
	private Long driverId;
	
	private String driverName;
	
	private String source;
	
	private String destination;
	

	
	private Long shipmentTypeId;
	
	private String shipmentTypeName;
	
	private String shipmentQuantity;
	
	private Long shipmentTransTypeId;
	
	private String shipmentTransTypeName;
	
	private String shiftType;
	
	private String inDriver;
	
	private String secondDriver;
	
	private Date ShipmentDate;
	
	private String kms;


}
