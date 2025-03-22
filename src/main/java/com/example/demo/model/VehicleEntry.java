package com.example.demo.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class VehicleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Vehiclenumber", nullable = false, unique = true)
    private String vehicleNumber;

    @Column(name = "Ownername", nullable = false)
    private String ownerName;

    @Column(name = "Registrationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Column(name = "Fcvalidupto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fcValidUpto;

    @Column(name = "Taxvalidupto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date taxValidUpto;

    @Column(name = "Insurancevalidupto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insuranceValidUpto;

    @Column(name = "Puccvalidupto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date puccValidUpto;

    @Column(name = "Permitvalidupto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date permitValidUpto;

    @Column(name = "Npvalidupto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date npValidUpto;

    @Column(name = "Rtooffice")
    private String rtoOffice;

    @Column(name = "Noofwheels")
    private int noOfWheels;

    @Column(name = "Vehicleclass")
    private String vehicleClass;

    @Column(name = "Fastagdetails")
    private String fastagDetails;
    
    @CreationTimestamp
    @Column(name = "Createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @UpdateTimestamp
    @Column(name = "Lastmodifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "EngineNumber")
    private String engineNumber;
    
    @Column(name = "chassisNumber")
    private String chassisNumber;
    
    @Column(name = "BrandName")
    private String brandName;
    }

