package com.example.demo.service;

import java.util.List;

import com.example.demo.data.ResponseData;
import com.example.demo.model.CountryCode;
import com.example.demo.model.Customers;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.CustomersPayload;

public interface CustomerService {

	public ResponseData saveCustomer(CustomersPayload customersPayload);

	public List<Customers> getCustomerDetails(CommonPagination commonPagination);

	public List<CountryCode> getTeleCode();

	public ResponseData deleteCustomerById(Long customerId);

}
