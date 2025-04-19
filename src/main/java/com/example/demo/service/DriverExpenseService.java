package com.example.demo.service;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.DriverExpensePayload;

public interface DriverExpenseService {

	ResponseData saveDriverExpense(DriverExpensePayload driverExpensePayload);

	PaginationData getDriversExpense(CommonPagination commonPagination);

	ResponseData deleteDriverExpenseById(Long driverExpenseId);

	ResponseData updateDriverExpense(Long driverExpenseId, DriverExpensePayload driverExpensePayload);

}
