package com.example.demo.service.serviceImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.example.demo.model.Billing;
import com.example.demo.payload.BillingPaylaod;
import com.example.demo.repository.BillingRepository;
import com.example.demo.service.BillingService;
import com.itextpdf.text.DocumentException;

@Service
public class BillingServiceImpl implements BillingService{
	
	@Autowired
	private BillingRepository billingRepository;
	
	
	 public BillingServiceImpl(TemplateEngine templateEngine) {
		super();
		this.templateEngine = templateEngine;
	}

	private final TemplateEngine templateEngine;

	@Override
	public ByteArrayOutputStream  generateBillingPdf(BillingPaylaod billingPayload) throws DocumentException, IOException {
		
		    saveBillingLog(billingPayload);
		
	        Context context = new Context();
	        context.setVariable("invoice", billingPayload);

	        String htmlContent = templateEngine.process("invoice_template", context);

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        ITextRenderer renderer = new ITextRenderer();
	        renderer.setDocumentFromString(htmlContent, null);
	        renderer.layout();
	        renderer.createPDF(outputStream, false);
	        renderer.finishPDF();

	        return outputStream;
		
		
	}
	
	
	public void saveBillingLog(BillingPaylaod billingPayload)
	{
		Billing billing=new Billing();
		billing.setCgst(billingPayload.getCGST());
		billing.setFromDate(billingPayload.getFromDate());
		billing.setToDate(billingPayload.getToDate());
		//billing.setCustomerId(billingPayload.get);
	}

}
