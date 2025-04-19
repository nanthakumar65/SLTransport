package com.example.demo.service.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.Customers;
import com.example.demo.model.Vendors;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.VendorPayload;
import com.example.demo.repository.CustomersRepository;
import com.example.demo.repository.VendorsRepository;
import com.example.demo.service.VendorsService;

@Service
public class VendorsServiceImpl implements VendorsService{

	@Autowired
	private VendorsRepository vendorsRepo;
	
	@Autowired
	private CustomersRepository customersRepository;

	@Override
	public ResponseData saveVendor(VendorPayload vendorPayload) {

		ResponseData responseData = new ResponseData();
		Vendors vendors = new Vendors();
		vendors.setSiteName(vendorPayload.getSiteName());
		vendors.setPhoneNumber(vendorPayload.getPhoneNumber());
		vendors.setIfscCode(vendorPayload.getIfscCode());
		vendors.setGstnNumber(vendorPayload.getGstnNumber());
		vendors.setCustomerId(vendorPayload.getCustomerId());
		Optional<Customers> customers = customersRepository.findById(vendorPayload.getCustomerId());
		vendors.setCustomerName(customers.get().getCustomerName());
		vendors.setContactPersonName(vendorPayload.getContactPersonName());
		vendors.setBankName(vendorPayload.getBankName());
		vendors.setAddress(vendorPayload.getAddress());
		vendors.setAccNumber(vendorPayload.getAccNumber());
		vendors.setAccHolderName(vendorPayload.getAccHolderName());
		Vendors saveVendor = vendorsRepo.save(vendors);
		if (saveVendor != null) {
			responseData.setResult(true);
			responseData.setStatus("Success");
			responseData.setMessage("Successfully Saved");
		} else {
			responseData.setMessage("Failed");
		}
		return responseData;
	}

	@Override
	public PaginationData getVendors(CommonPagination commonPagination) {
		PaginationData paginationData = new PaginationData();
		Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(), commonPagination.getPageSize().intValue());
		long count = vendorsRepo.count();
		Page<Vendors> vendors = vendorsRepo.findAll(pageable);
		List<Vendors> vendorContent = vendors.getContent();
		if(!vendorContent.isEmpty() && vendorContent !=null) {
			paginationData.setList(vendorContent);
			paginationData.setTotalCount(count);
			return paginationData;
		}else {
			paginationData.setList(Collections.emptyList());
			paginationData.setTotalCount(0L);
			return paginationData;
		}
		
	}

	@Override
	public ResponseData deleteVendors(Long vendorId) {
		ResponseData responseData = new ResponseData();
		vendorsRepo.deleteById(vendorId);
		responseData.setMessage("Successfully Deleted");
		responseData.setResult(true);
		responseData.setStatus("Success");
		return responseData;
	}

	@Override
	public void updateVendor(Long vendorId, VendorPayload vendorPayload) {

		ResponseData responseData = new ResponseData();
		Optional<Vendors> vendor = vendorsRepo.findById(vendorId);
		if (vendor.isPresent()) {
			vendor.get().setSiteName(vendorPayload.getSiteName());
			vendor.get().setPhoneNumber(vendorPayload.getPhoneNumber());
			vendor.get().setIfscCode(vendorPayload.getIfscCode());
			vendor.get().setGstnNumber(vendorPayload.getGstnNumber());
			vendor.get().setCustomerId(vendorPayload.getCustomerId());
			Optional<Customers> customers = customersRepository.findById(vendorPayload.getCustomerId());
			vendor.get().setCustomerName(customers.get().getCustomerName());
			vendor.get().setContactPersonName(vendorPayload.getContactPersonName());
			vendor.get().setBankName(vendorPayload.getBankName());
			vendor.get().setAddress(vendorPayload.getAddress());
			vendor.get().setAccNumber(vendorPayload.getAccNumber());
			vendor.get().setAccHolderName(vendorPayload.getAccHolderName());
			Vendors updateVendor = vendorsRepo.save(vendor.get());
			if (updateVendor != null) {
				responseData.setMessage("Updated Successfully");
				responseData.setResult(true);
				responseData.setStatus("Success");
			} else {
				responseData.setMessage("Updated Failed");
			}
		}
	}
	
	
	
	
}
