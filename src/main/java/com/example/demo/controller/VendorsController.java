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

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.VendorPayload;
import com.example.demo.service.VendorsService;

@RestController
@CrossOrigin
public class VendorsController {

	@Autowired
	private VendorsService vendorsService;
	
	@PostMapping("/saveVendor")
	public ResponseEntity<ResponseData> saveVendor(@RequestBody VendorPayload vendorPayload) {
		ResponseData saveVendor = vendorsService.saveVendor(vendorPayload);
		if (saveVendor.getResult() == true) {
			return new ResponseEntity<>(saveVendor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(saveVendor, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@PostMapping("/getVendorsDetails")
	public ResponseEntity<PaginationData> getVendors(@RequestBody CommonPagination commonPagination) {

		PaginationData paginationData = vendorsService.getVendors(commonPagination);
		if (paginationData != null) {
			return new ResponseEntity<>(paginationData, HttpStatus.OK);
		}
		return new ResponseEntity<>(paginationData, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/deleteVendorById/{vendorId}")
	public ResponseEntity<ResponseData> deleteVendors(@PathVariable("vendorId") Long vendorId) {
		ResponseData deleteVendors = vendorsService.deleteVendors(vendorId);
		if (deleteVendors.getResult() == true) {
			return new ResponseEntity<>(deleteVendors, HttpStatus.OK);
		}
		return new ResponseEntity<>(deleteVendors, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@PutMapping("updateVendor/{vendorId}")
	public void updateVendor(@PathVariable("vendorId") Long vendorId, @RequestBody VendorPayload vendorPayload) {
		vendorsService.updateVendor(vendorId, vendorPayload);
	}
	
	
	
	
}
