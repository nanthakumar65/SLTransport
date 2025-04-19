package com.example.demo.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="DriverShipment")
public class DriverShipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id",unique = true,nullable = false)
	private Long Id ;
	
	@Column(name="CustomerId")
	private Long customerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CustomerId",referencedColumnName ="customerId",updatable = false,insertable = false)
	private Customers customerDetails;
	
	@Column(name="VehicleNumberId")
	private Long vehicleNumberId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="VehicleNumberId",referencedColumnName ="id",updatable = false,insertable = false)
	private VehicleEntry vechileDetails;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="DriverId",referencedColumnName ="driverId",updatable = false,insertable = false)
	private Drivers driverDetails;
	
	@Column(name="DriverId")
	private Long driverId;
	
	
	@Column(name="ShipmentSource")
	private String shipmentSource;
	
	@Column(name="ShipmentDestination")
	private String shipmentDestination ;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ShipmentTypeId",referencedColumnName ="materialId",updatable = false,insertable = false)
	private MaterialMaster  shipmentDetails;
	
	@Column(name="ShipmentTypeId")
	private Long shipmentTypeId;
	
	@Column(name="ShipmentQuantity")
	private String shipmentQuantity;
	
	@Column(name="ShipmentTransTypeId")
	private Long shipmentTransTypeId;
	
	@ManyToOne
	@JoinColumn(name="ShipmentTransTypeId",referencedColumnName ="id",updatable = false,insertable = false)
	private ShipmentTransType shipmentTransTypeDetails;
	
	@Column(name="ShiftType",nullable = false)
	private String shiftType;
	
	@Column(name="Indriver")
	private String indriver;
	
	@Column(name="SecondDriverName",nullable = true)
	private String secondDriverName;
	
	@CreationTimestamp
	@Column(name="CreatedDate",nullable = false)
	private String createdDate;
	
	@UpdateTimestamp
	@Column(name="ModifiedDate")
	private String modifiedDate;
	
	@Column(name="ShipmentDate")
	private Date shipmentDate;
	
	@Column(name="kms")
	private String kms;

}
