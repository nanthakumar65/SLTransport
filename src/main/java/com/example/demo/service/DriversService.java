package com.example.demo.service;

import java.util.List;

import com.example.demo.data.DriversNameData;
import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.NewDriverPayload;

public interface DriversService {


	public ResponseData saveDriverDetails(NewDriverPayload driverDataPayload);

	public PaginationData getDriversDetails(Long isActive,CommonPagination commonPagination);

	public List<DriversNameData> getDriversName();

	public ResponseData deleteDriverById(Long driverId);

	public ResponseData updateDriversDetails(NewDriverPayload driverDataPayload, Long driverId);
}
