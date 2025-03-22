package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseData;
import com.example.demo.model.DriverExpenseType;
import com.example.demo.model.DriverShipment;
import com.example.demo.model.MaterialMaster;
import com.example.demo.model.ShipmentTransType;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.DriverShimentPayload;
import com.example.demo.service.DriverShimentService;

@RestController
@CrossOrigin(origins = "http://192.168.45.134:2020")
public class DriverShimentController {

	@Autowired
	private DriverShimentService driverShimentService;
	
	@PostMapping("/saveDriverShipment")
	public ResponseEntity<ResponseData> ResponseEntity(@RequestBody DriverShimentPayload driverShimentPayload) {
		ResponseData responseData = driverShimentService.saveShipment(driverShimentPayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getMaterialType")
	public ResponseEntity<List<MaterialMaster>> getMaterial() {
		List<MaterialMaster> materialTypeList = driverShimentService.getMaterialType();
		if (!materialTypeList.isEmpty()) {
			return new ResponseEntity<>(materialTypeList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(materialTypeList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getShipmentTransType")
	public ResponseEntity<List<ShipmentTransType>> getShipmentTransType() {

		List<ShipmentTransType> shipmentTransTypeList = driverShimentService.getShipmentTransType();
		if (!shipmentTransTypeList.isEmpty()) {
			return new ResponseEntity<>(shipmentTransTypeList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(shipmentTransTypeList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getDriverExpenseType")
	public ResponseEntity<List<DriverExpenseType>> getDriverExpenseType() {
		List<DriverExpenseType> driverExpenseTypeList = driverShimentService.getDriverExpenseType();
		if (!driverExpenseTypeList.isEmpty()) {
			return new ResponseEntity<>(driverExpenseTypeList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(driverExpenseTypeList, HttpStatus.OK);
		}
	}

	@PostMapping("/getDriverShipment")
	public ResponseEntity<List<DriverShipment>> getDriverShipment(
			@RequestBody CommonPagination commonPagination) {
		Page<DriverShipment> driverShipmentList = driverShimentService
				.getDriverShipment(commonPagination.getPageNo(), commonPagination.getPageSize());
		if (driverShipmentList != null) {
			return new ResponseEntity<>(driverShipmentList.getContent(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(driverShipmentList.getContent(), HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
