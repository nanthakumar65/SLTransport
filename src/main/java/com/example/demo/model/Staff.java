package com.example.demo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Staff")
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StaffID")
    private Long staffId;

    @Column(name = "StaffName", length = 100)
    private String staffName;

    @Column(name = "FatherName", length = 100)
    private String fatherName;

    @Column(name = "Address", length = 255)
    private String address;

    @Column(name = "AadharNo", length = 12, unique = true)
    private Long aadharNo;

    @Column(name = "PhoneNo", length = 15)
    private String phoneNo;

    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "BloodGroup", length = 5)
    private String bloodGroup;

    @Column(name = "BankAccName", length = 100)
    private String bankAccName;

    @Column(name = "BankAccNo", length = 20)
    private String bankAccNo;

    @Column(name = "IFSCCode", length = 11)
    private String ifscCode;

    @Column(name = "BranchName", length = 100)
    private String branchName;
    
    @Column(name="UserName")
    private String userName;
    
    @Column(name="UserPwd")
    private String userPwd;

    }
