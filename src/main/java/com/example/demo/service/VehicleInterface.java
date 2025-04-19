package com.example.demo.service;

import java.util.List;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.data.VechileNumberResponse;
import com.example.demo.model.VehicleEntry;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.VehiclePayload;

public interface VehicleInterface {

	public ResponseData saveVechileDetails(VehiclePayload saveVechilePayload);

	public ResponseData updateVechileDetails(Long vehicleId ,VehiclePayload updateVechilePayload);

	public ResponseData deleteVehicleDetails(Long vehicleId);

	public PaginationData getVechileList(CommonPagination commonPagination);

	public List<VechileNumberResponse> getVechileNumber();


}
