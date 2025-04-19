package com.example.demo.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.data.CustomerNameResponse;
import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.CountryCode;
import com.example.demo.model.Customers;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.CustomersPayload;
import com.example.demo.repository.CountryCodeRepository;
import com.example.demo.repository.CustomersRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomersRepository customersRepo;
	
	@Autowired
	private CountryCodeRepository countryCodeRepo;

	@Override
	public ResponseData saveCustomer(CustomersPayload customersPayload) {
		
		ResponseData responseData = new ResponseData();
		Customers customer = new Customers();
		customer.setCustomerName(customersPayload.getCustomerName());
		customer.setAddress(customersPayload.getAddress());
		customer.setTeleCode(customersPayload.getTeleCode());
		customer.setPhone(customersPayload.getPhone());
		customer.setGstNumber(customersPayload.getGstNumber());
		customer.setCountry(customersPayload.getCountry());
		customer.setState(customersPayload.getState());
		Customers saveCustomers = customersRepo.save(customer);
		if(saveCustomers != null) {
			responseData.setResult(true);
			responseData.setStatus("Success");
			responseData.setMessage("Successfully Saved");
		}else {
			responseData.setMessage("Failed");
		}
		return responseData;
	}

	@Override
	public PaginationData getCustomerDetails(CommonPagination commonPagination) {
		PaginationData paginationData = new PaginationData();
		 long count = customersRepo.count();
		Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(),
				commonPagination.getPageSize().intValue());
		Page<Customers> PageCustomersList = customersRepo.findAll(pageable);
		List<Customers> customersList = PageCustomersList.getContent();
		if (!customersList.isEmpty() && customersList != null) {
			paginationData.setList(customersList);
			paginationData.setTotalCount(count);
		}
		return paginationData;
	}

	@Override
	public List<CountryCode> getTeleCode() {
		List<CountryCode> countryCodeList = countryCodeRepo.findAll();
		if(!countryCodeList.isEmpty() && countryCodeList != null) {
			return countryCodeList;
		}
		return Collections.emptyList();
	}

	@Override
	public ResponseData deleteCustomerById(Long customerId) {
		ResponseData responseData = new ResponseData();
		Optional<Customers> coustomer = customersRepo.findById(customerId);
		if (coustomer.isPresent()) {
			customersRepo.deleteById(customerId);
			responseData.setMessage("Successfully Deleted");
			responseData.setResult(true);
			responseData.setStatus("Success");
		} else {
			responseData.setMessage("Deleted Failed");
		}
		return responseData;
	}

	@Override
	public ResponseData updateCustomer(Long customerId, CustomersPayload customersPayload) {
		ResponseData responseData = new ResponseData();
		Optional<Customers> customer = customersRepo.findById(customerId);
		if (customer.isPresent()) {
			customer.get().setCustomerName(customersPayload.getCustomerName());
			customer.get().setAddress(customersPayload.getAddress());
			customer.get().setCountry(customersPayload.getCountry());
			customer.get().setGstNumber(customersPayload.getGstNumber());
			customer.get().setPhone(customersPayload.getPhone());
			customer.get().setTeleCode(customersPayload.getTeleCode());
			customer.get().setState(customersPayload.getState());
			Customers save = customersRepo.save(customer.get());
			if (save != null) {
				responseData.setMessage("Updated Successfully");
				responseData.setResult(true);
				responseData.setStatus("Success");
			} else {
				responseData.setMessage("Updated Failed");
			}
		}
		return responseData;
	}

	@Override
	public List<CustomerNameResponse> getCustomerName() {
		
		List<Customers>cutomersList=customersRepo.findAll();
		
		List<CustomerNameResponse> customerResponseList=new ArrayList<>();
		
		if(!cutomersList.isEmpty())
		{
			for(Customers customers:cutomersList)
			{
				CustomerNameResponse customerNameResponse=new CustomerNameResponse();
				customerNameResponse.setCustomerId(customers.getCustomerId());
				customerNameResponse.setCustomerName(customers.getCustomerName()); 
				customerResponseList.add(customerNameResponse);
			}
		}
		
		return customerResponseList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
