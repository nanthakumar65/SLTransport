package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.data.DriverShipmentData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.DriverExpenseType;
import com.example.demo.model.DriverShipment;
import com.example.demo.model.MaterialMaster;
import com.example.demo.model.ShipmentTransType;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.DriverShimentPayload;

public interface DriverShimentService {

	public List<MaterialMaster> getMaterialType();

	public List<ShipmentTransType> getShipmentTransType();

	public List<DriverExpenseType> getDriverExpenseType();

	public ResponseData saveShipment(DriverShimentPayload driverShimentPayload);

	public List<DriverShipmentData> getDriverShipment(CommonPagination commonPagination);

	public ResponseData updateShipment(Long shipmentId, DriverShimentPayload updateShipmentPayload);

	public ResponseData deleteDriverShipment(Long shipmentId);

}
