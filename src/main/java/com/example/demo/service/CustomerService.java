package com.example.demo.service;

import java.util.List;

import com.example.demo.data.CustomerNameResponse;
import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.CountryCode;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.CustomersPayload;

public interface CustomerService {

	public ResponseData saveCustomer(CustomersPayload customersPayload);

	public PaginationData getCustomerDetails(CommonPagination commonPagination);

	public List<CountryCode> getTeleCode();

	public ResponseData deleteCustomerById(Long customerId);

	public ResponseData updateCustomer(Long customerId, CustomersPayload customersPayload);

	public List<CustomerNameResponse> getCustomerName();

}
