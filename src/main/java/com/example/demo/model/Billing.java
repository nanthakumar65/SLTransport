package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

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

@Table(name="Billing")
@Entity
@Data
public class Billing {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "BillingId")
	    private Long billingId;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "CustomerId", nullable = false,updatable = false,insertable=false)
	    private Customers customer;
	   
	    @Column(name="CustomerId")
	    private Long customerId;
	   
	    @Column(name="MaterialId")
	    private Long MaterialId;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "MaterialId", nullable = false,updatable = false,insertable=false)
	    private MaterialMaster material;

	    @Column(name = "FromDate")
	    private Date fromDate;

	    @Column(name = "ToDate")
	    private Date toDate;

	    @Column(name = "CreatedDate")
	    private Date createdDate;

	    @Column(name = "ModifiedDate")
	    private Date modifiedDate;

	    @Column(name = "Quantity", precision = 10, scale = 2)
	    private BigDecimal quantity;

	    @Column(name = "Rate", precision = 10, scale = 2)
	    private BigDecimal rate;

	    @Column(name = "CGST", precision = 10, scale = 2)
	    private BigDecimal cgst;

	    @Column(name = "SCST", precision = 10, scale = 2)
	    private BigDecimal scst;

	    @Column(name = "RoundOff", precision = 10, scale = 2)
	    private BigDecimal roundOff;

	    @Column(name = "Total", precision = 10, scale = 2)
	    private BigDecimal total;
}
