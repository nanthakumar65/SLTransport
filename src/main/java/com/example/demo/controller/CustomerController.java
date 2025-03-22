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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.DateUtil;
import com.example.demo.data.CountryData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.CountryCode;
import com.example.demo.model.Customers;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.CustomersPayload;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://192.168.45.134:2020")
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
	
	@GetMapping("/getCustomersDetails")
	public ResponseEntity<List<Customers>> getCustomerDetails(@RequestBody CommonPagination commonPagination) {
		List<Customers> customersList = customerService.getCustomerDetails(commonPagination);
		if (!customersList.isEmpty()) {
			return new ResponseEntity<>(customersList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(customersList, HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	
	
	

}
