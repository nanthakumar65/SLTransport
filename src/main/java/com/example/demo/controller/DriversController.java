package com.example.demo.controller;

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

import com.example.demo.data.DriversNameData;
import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.NewDriverPayload;
import com.example.demo.service.DriversService;

@RestController
@CrossOrigin(origins = "http://192.168.45.134:2020")
public class DriversController {
	
	@Autowired
	private DriversService driversService;	
	
	@PostMapping(value = "/saveDriverDetails")
	public ResponseEntity<ResponseData> saveDriverDetails(@RequestBody NewDriverPayload driverDataPayload) {
		ResponseData saveDriverDetails = driversService.saveDriverDetails(driverDataPayload);
		if (saveDriverDetails.getResult() == true) {
			return new ResponseEntity<>(saveDriverDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(saveDriverDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/getDriversDetails")
	public ResponseEntity<PaginationData> getDriversDetails(@RequestBody CommonPagination commonPagination) {
		PaginationData paginationData = driversService.getDriversDetails(commonPagination.getIsActive(),commonPagination);

		if (paginationData != null) {
			return new ResponseEntity<>(paginationData, HttpStatus.OK);
		}
		return new ResponseEntity<>(paginationData, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getDriversName")
	public ResponseEntity<DriversNameData> getDriversName() {
		DriversNameData driversName = driversService.getDriversName();
		if (driversName != null) {
			return new ResponseEntity<>(driversName, HttpStatus.OK);
		}
		return new ResponseEntity<>(driversName, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/deleteDriverById/{driverId}")
	public ResponseEntity<ResponseData> deleteDriverById(@PathVariable("driverId") Long driverId) {
		ResponseData reponseData = driversService.deleteDriverById(driverId);
		if (reponseData.getResult() == true) {
			return new ResponseEntity<>(reponseData, HttpStatus.OK);
		}
		return new ResponseEntity<>(reponseData, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PutMapping(value="/updateDriverDetails/{DriverId}")
	public ResponseEntity<ResponseData> updateDriversDetails(@PathVariable("DriverId") Long DriverId,@RequestBody NewDriverPayload driverDataPayload)
	{
		ResponseData saveDriverDetails = driversService.updateDriversDetails(driverDataPayload,DriverId);
		if (saveDriverDetails.getResult() == true) {
			return new ResponseEntity<>(saveDriverDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(saveDriverDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
