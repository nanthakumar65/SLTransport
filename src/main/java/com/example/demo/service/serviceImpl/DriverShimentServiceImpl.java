package com.example.demo.service.serviceImpl;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.data.ResponseData;
import com.example.demo.model.DriverExpenseType;
import com.example.demo.model.DriverShipment;
import com.example.demo.model.MaterialMaster;
import com.example.demo.model.ShipmentTransType;
import com.example.demo.payload.DriverShimentPayload;
import com.example.demo.repository.DriverExpenseTypeRepository;
import com.example.demo.repository.DriverShipmentRepository;
import com.example.demo.repository.MaterialMasterRepository;
import com.example.demo.repository.ShipmentTransTypeRepository;
import com.example.demo.service.DriverShimentService;

@Service
public class DriverShimentServiceImpl implements DriverShimentService{

	@Autowired
	private MaterialMasterRepository materialMasterRepo;
	
	@Autowired
	private ShipmentTransTypeRepository shipmentTransTypeRepository;
	
	@Autowired
	private DriverExpenseTypeRepository driverExpenseTypeRepo;
	
	@Autowired
	private DriverShipmentRepository driverShipmentRepo;
	
	@Override
	public List<MaterialMaster> getMaterialType() {
		
		List<MaterialMaster> materialMasterList = materialMasterRepo.findAll();
		if(!materialMasterList.isEmpty() && materialMasterList != null) {
			return materialMasterList;
		}
		return Collections.emptyList();
	}

	@Override
	public List<ShipmentTransType> getShipmentTransType() {
		
		List<ShipmentTransType> shipmentTransTypeList = shipmentTransTypeRepository.findAll();
		if(!shipmentTransTypeList.isEmpty() && shipmentTransTypeList != null) {
			return shipmentTransTypeList;
		}
		return Collections.emptyList();
	}

	@Override
	public List<DriverExpenseType> getDriverExpenseType() {
		
		List<DriverExpenseType> driverExpenseTypeList = driverExpenseTypeRepo.findAll();
		if(!driverExpenseTypeList.isEmpty() && driverExpenseTypeList != null) {
			return driverExpenseTypeList;
		}
		return Collections.emptyList();
	}

	@Override
	public ResponseData saveShipment(DriverShimentPayload driverShimentPayload) {
		ResponseData responseData = new ResponseData();
		DriverShipment driverShipment = new DriverShipment();
		driverShipment.setName(driverShimentPayload.getName());
		driverShipment.setShipmentSource(driverShimentPayload.getSource());
		driverShipment.setShipmentDestination(driverShimentPayload.getDestination());
		driverShipment.setDriverExpenseType(driverShimentPayload.getDriverExpenseType());
		driverShipment.setDriverExpense(driverShimentPayload.getDriverExpense());
		driverShipment.setShipmentType(driverShimentPayload.getShipmentType());
		driverShipment.setShipmentQuantity(driverShimentPayload.getShipmentQuantity());
		driverShipment.setShipmentTransType(driverShimentPayload.getShipmentTransType());
		driverShipment.setShiftType(driverShimentPayload.getShiftType());
		driverShipment.setIndriver(driverShimentPayload.getInDriver());
		driverShipment.setVehicleNumber(driverShimentPayload.getVehicleNumber());
		DriverShipment saveDriverShipment = driverShipmentRepo.save(driverShipment);
		if (saveDriverShipment != null) {
			responseData.setResult(true);
			responseData.setStatus("Success");
			responseData.setMessage("Successfully Saved");
		} else {
			responseData.setMessage("Failed");
		}
		return responseData;
	}

	@Override
	public Page<DriverShipment> getDriverShipment(Long pageNo, Long pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo.intValue(), pageSize.intValue());
	    Page<DriverShipment> shipments = driverShipmentRepo.findAll(pageable);
	    if( shipments != null) {
	    	return shipments;
	    }
	    return null;
	}

	
}
