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
import com.example.demo.payload.MaterialMasterPayload;
import com.example.demo.service.MaterialMasterService;

@RestController
@CrossOrigin
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
	
	@PutMapping(value = "/updateMaterial/{materialId}")
	public ResponseEntity<ResponseData> updateMaterial(
			@PathVariable("materialId") Long materialId,@RequestBody MaterialMasterPayload materialMasterPayload) {
		ResponseData responseData = materialMasterService.updateMaterial(materialId,materialMasterPayload);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/deleteMaterialById/{materialId}")
	public ResponseEntity<ResponseData> deleteMaterialById(@PathVariable("materialId") Long materialId) {
		ResponseData responseData = materialMasterService.deleteMaterialById(materialId);
		if (responseData.getResult() == true) {
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/getMaterials")
	public ResponseEntity<PaginationData> getMaterials(@RequestBody CommonPagination commonPagination) {
		PaginationData paginationData = materialMasterService.getMaterials(commonPagination);
		if (paginationData != null) {
			return new ResponseEntity<>(paginationData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(paginationData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
