package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.DriverExpensePayload;
import com.example.demo.service.DriverExpenseService;

@RestController
@CrossOrigin
public class DriverExpenseController {

	@Autowired
	private DriverExpenseService driverExpenseService;

	@PostMapping("saveDriverExpense")
	public ResponseEntity<ResponseData> saveDriverExpense(@RequestBody DriverExpensePayload driverExpensePayload) {
		ResponseData responseData = driverExpenseService.saveDriverExpense(driverExpensePayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("getDriversExpenseDetails")
	public ResponseEntity<PaginationData> getDriversExpense(@RequestBody CommonPagination commonPagination) {
		PaginationData paginationData = driverExpenseService.getDriversExpense(commonPagination);
		if (paginationData != null) {
			return new ResponseEntity<>(paginationData, HttpStatus.OK);
		}
		return new ResponseEntity<>(paginationData, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("deleteDriverExpenseById/{driverExpenseId}")
	public ResponseEntity<ResponseData> deleteDriverExpenseById(@PathVariable("driverExpenseId") Long driverExpenseId) {
		ResponseData deleteDriverExpenseById = driverExpenseService.deleteDriverExpenseById(driverExpenseId);
		if (deleteDriverExpenseById.getResult() == true) {
			return new ResponseEntity<>(deleteDriverExpenseById, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(deleteDriverExpenseById, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("updateDriverExpense/{driverExpenseId}")
	public ResponseEntity<ResponseData> updateDriverExpense(@PathVariable("driverExpenseId") Long driverExpenseId, @RequestBody DriverExpensePayload driverExpensePayload) {
		ResponseData responseData = driverExpenseService.updateDriverExpense(driverExpenseId, driverExpensePayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
