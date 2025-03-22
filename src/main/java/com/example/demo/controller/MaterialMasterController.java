package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ResponseData;
import com.example.demo.payload.MaterialMasterPayload;
import com.example.demo.service.MaterialMasterService;

@RestController
@CrossOrigin(origins = "http://192.168.45.134:2020")
public class MaterialMasterController {
	
	@Autowired
	private MaterialMasterService materialMasterService;
	
	@PostMapping(value = "/saveMaterialMasterDetails")
	public ResponseEntity<ResponseData> saveMaterialMasterDetails(
			@RequestBody MaterialMasterPayload materialMasterPayload) {
		ResponseData responseData = materialMasterService.saveMaterialMasterDetails(materialMasterPayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/updateMaterial")
	public ResponseEntity<ResponseData> updateMaterial(
			@RequestBody MaterialMasterPayload materialMasterPayload) {
		ResponseData responseData = materialMasterService.updateMaterial(materialMasterPayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/deleteMaterialById")
	public ResponseEntity<ResponseData> deleteMaterialById(@PathVariable("materialId") Long materialId) {
		ResponseData responseData = materialMasterService.deleteMaterialById(materialId);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
