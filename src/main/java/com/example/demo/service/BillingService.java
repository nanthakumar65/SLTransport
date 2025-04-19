package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.example.demo.payload.BillingPaylaod;
import com.itextpdf.text.DocumentException;

public interface BillingService {

	ByteArrayOutputStream generateBillingPdf(BillingPaylaod billingPayload) throws DocumentException, IOException;

}
