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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.VehiclePayload;
import com.example.demo.service.VehicleInterface;

@CrossOrigin(origins = "http://192.168.45.134:2020")
@RestController
public class VehicleController {
	
	@Autowired
	private VehicleInterface vehicleInterface;
	
	@PostMapping(value="/saveVehicleDetails")
	public ResponseEntity<ResponseData> saveVechileDetails(@RequestBody VehiclePayload saveVechilePayload) {
		ResponseData responseData = vehicleInterface.saveVechileDetails(saveVechilePayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PutMapping(value="/updateVehicleDetails/{vehicleId}")
	public ResponseEntity<ResponseData> updateVechileDetails(@PathVariable("vehicleId") Long vehicleId,@RequestBody VehiclePayload updateVechilePayload)
	{
		ResponseData responseData = vehicleInterface.updateVechileDetails(vehicleId,updateVechilePayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@DeleteMapping(value="/deleteVehicleDetailsById/{vehicleId}")
	public ResponseEntity<ResponseData> deleteVehicleDetails(@PathVariable(name = "vehicleId")  Long vehicleId)
	{
		ResponseData responseData = vehicleInterface.deleteVehicleDetails(vehicleId);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	
	}
	@PostMapping(value="/getVehicleDetails")
	public ResponseEntity<PaginationData> getVechileList(@RequestBody CommonPagination commonPagination) {
		PaginationData VehiclePaginationData = vehicleInterface.getVechileList(commonPagination);
		if (VehiclePaginationData != null) {
			return new ResponseEntity<>(VehiclePaginationData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(VehiclePaginationData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}


