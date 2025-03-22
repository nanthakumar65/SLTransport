package com.example.demo.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DriverShipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id",unique = true,nullable = false)
	private Long Id ;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="VehicleNumber")
	private String vehicleNumber;
	
	@Column(name="ShipmentSource")
	private String shipmentSource;
	
	@Column(name="ShipmentDestination")
	private String shipmentDestination ;
	
	@Column(name="DriverExpenseType")
	private String driverExpenseType; 
	
	@Column(name="DriverExpense")
	private String driverExpense;
	
	@Column(name="ShipmentType")
	private String shipmentType;
	
	@Column(name="ShipmentQuantity")
	private String shipmentQuantity;
	
	@Column(name="ShipmentTransType")
	private String shipmentTransType; 
	
	@Column(name="ShiftType")
	private String shiftType;
	
	@Column(name="Indriver")
	private String indriver;
	
	@CreationTimestamp
	@Column(name="CreatedDate")
	private String createdDate;

}
