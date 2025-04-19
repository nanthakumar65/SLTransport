package com.example.demo.payload;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class BillingPaylaod {
	
	private String customerName;
	
	private String materialName;
	
	private Long invoiceNo=12345l;
	
	private String gstNumber="33GCTSTSIAKA";
	
	private BigDecimal quantity;
	
	private BigDecimal rate;
	
	private BigDecimal CGST;
	
	private BigDecimal SCST;
	
	private  BigDecimal totalAmount;
	
	private String amountInWords;
	
	private Date invoiceDate=new Date();
	
	private Date fromDate;
	
	private Date toDate;
	
	private String companyName="SRI SHANMUGHAR TRANSPORT";
	private String companyAddress="64, Anna Salai, Pudukottai Main Road, Ponamaravathy Tamil Nadu 622408";
	
	
	

}
