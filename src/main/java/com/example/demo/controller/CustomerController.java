package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.DateUtil;
import com.example.demo.data.CustomerNameResponse;
import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.CountryCode;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.CustomersPayload;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseData> saveCustomer(@RequestBody CustomersPayload customersPayload) {
		ResponseData responseData = customerService.saveCustomer(customersPayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/getCustomersDetails")
	public ResponseEntity<PaginationData> getCustomerDetails(@RequestBody CommonPagination commonPagination) {
		PaginationData paginationData = customerService.getCustomerDetails(commonPagination);
		if (paginationData !=null) {
			return new ResponseEntity<>(paginationData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(paginationData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getTeleCode")
	public ResponseEntity<List<CountryCode>> getTeleCode() {
		List<CountryCode> teleCodeList = customerService.getTeleCode();
		if (!teleCodeList.isEmpty()) {
			return new ResponseEntity<>(teleCodeList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(teleCodeList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteCustomerById/{customerId}")
	public ResponseEntity<ResponseData> deleteCustomerById(@PathVariable("customerId") Long customerId) {
		ResponseData responseData = customerService.deleteCustomerById(customerId);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getCountry")
	public ResponseEntity<ArrayList<String>> getCountry() {
		ArrayList<String> allCountry = DateUtil.getAllCountry();
		if (!allCountry.isEmpty()) {
			return new ResponseEntity<>(allCountry, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(allCountry, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<ResponseData> updateCustomer(@PathVariable("customerId") Long customerId,
			@RequestBody CustomersPayload customersPayload) {
		ResponseData updateCustomer = customerService.updateCustomer(customerId, customersPayload);
		if (updateCustomer != null) {
			return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateCustomer, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="/getCustomerName")
	public ResponseEntity<List<CustomerNameResponse>> getCustomerName() {
		List<CustomerNameResponse> customerNameList = customerService.getCustomerName();
		if (!customerNameList.isEmpty()) {
			return new ResponseEntity<>(customerNameList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(customerNameList, HttpStatus.OK);
		}

	}
	
	
	
	

}
