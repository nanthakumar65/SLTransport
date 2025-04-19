package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.BillingPaylaod;
import com.example.demo.service.BillingService;
import com.itextpdf.text.DocumentException;

@RestController
@CrossOrigin
public class BillingController {
	
	@Autowired
	private BillingService billingService;
	
	
	@PostMapping(value="/generateBillingPdf")
	public ResponseEntity<Resource> generateBillingPdf(@RequestBody BillingPaylaod billingPayload) throws DocumentException, IOException
	{
		ByteArrayOutputStream pdfStream = billingService.generateBillingPdf(billingPayload);

        ByteArrayResource resource = new ByteArrayResource(pdfStream.toByteArray());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
		
	}
	

}
