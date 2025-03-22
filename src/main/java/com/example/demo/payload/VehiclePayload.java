package com.example.demo.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class VehiclePayload {
	
    private String vehicleNumber;
    
    private String ownerName;
    
    private Date registrationDate;
    
    private Date fcValidUpto;
    
    private Date taxValidUpto;
    
    private Date insuranceValidUpto;
    
    private Date puccValidUpto;
    
    private Date permitValidUpto;
    
    private Date npValidUpto;
    
    private String rtoOffice;
    
    private int noOfWheels;
    
    private String vehicleClass;
    
    private String fastagDetails;
    
    private Long vehicleId;
    
    private String engineNumber;
    
    private String chassisNumber;
    
    private String brandName;
}

