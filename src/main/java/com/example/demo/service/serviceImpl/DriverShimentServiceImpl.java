package com.example.demo.service.serviceImpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Util.DateUtil;
import com.example.demo.data.DriverShipmentData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.DriverExpenseType;
import com.example.demo.model.DriverShipment;
import com.example.demo.model.MaterialMaster;
import com.example.demo.model.ShipmentTransType;
import com.example.demo.payload.CommonPagination;
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
	    
	    driverShipment.setCustomerId(driverShimentPayload.getCustomerId());
	    driverShipment.setShipmentSource(driverShimentPayload.getSource());
	    driverShipment.setShipmentDestination(driverShimentPayload.getDestination());
	    driverShipment.setDriverId(driverShimentPayload.getDriverId());
	    driverShipment.setShipmentTypeId(driverShimentPayload.getShipmentTypeId());
	    driverShipment.setShipmentQuantity(driverShimentPayload.getShipmentQuantity());
	    driverShipment.setShipmentTransTypeId(driverShimentPayload.getShipmentTransTypeId()); 
	    driverShipment.setShiftType(driverShimentPayload.getShiftType());
	    driverShipment.setIndriver(driverShimentPayload.getInDriver());
	    driverShipment.setSecondDriverName(driverShimentPayload.getSecondDriver()); 
	    driverShipment.setVehicleNumberId(driverShimentPayload.getVehicleId()); 
	    driverShipment.setShipmentDate(DateUtil.convertDateFormat(driverShimentPayload.getShipmentDate()));
	    
	    DriverShipment savedDriverShipment = driverShipmentRepo.save(driverShipment);
	 
	    if (savedDriverShipment != null && savedDriverShipment.getId() != null) {
	        responseData.setResult(true);
	        responseData.setStatus("Success");
	        responseData.setMessage("Successfully Saved");
	    } else {
	        responseData.setResult(false);
	        responseData.setStatus("Failed");
	        responseData.setMessage("Save operation failed");
	    }

	    return responseData;
	}
	
	@Override
	public List<DriverShipmentData> getDriverShipment(CommonPagination commonPagination) {
		List<DriverShipmentData> driverShipmentDataList = new ArrayList<>();
		List<DriverShipment> shipmentsList = null;
		/** SEARCH **/
		if (commonPagination.getSearchKey() != null) {

		}
		/** GET ALL SHIPMENTS **/
		else {
			Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(),
					commonPagination.getPageSize().intValue());
			Page<DriverShipment> shipmentsListPage = driverShipmentRepo.findAll(pageable);
			shipmentsList = shipmentsListPage.getContent();
		}
		if (shipmentsList != null ) {
			for (DriverShipment driverShipment : shipmentsList) {
				DriverShipmentData drivershipmentData = new DriverShipmentData();
				drivershipmentData.setDriverShipmentId(driverShipment.getId());
				drivershipmentData.setCustomerId(driverShipment.getCustomerId());
				drivershipmentData.setCustomerName(driverShipment.getCustomerDetails().getCustomerName());
				drivershipmentData.setDriverId(driverShipment.getDriverId());
				drivershipmentData.setDriverName(driverShipment.getDriverDetails().getName());
				drivershipmentData.setVehicleId(driverShipment.getVehicleNumberId());
				drivershipmentData.setVehicleNumber(driverShipment.getVechileDetails().getVehicleNumber());
				drivershipmentData.setShipmentTransTypeId(driverShipment.getShipmentTransTypeId());
				drivershipmentData.setShipmentTransTypeName(driverShipment.getShipmentTransTypeDetails().getName());
				drivershipmentData.setShiftType(driverShipment.getShiftType());
				drivershipmentData.setSource(driverShipment.getShipmentSource());
				drivershipmentData.setDestination(driverShipment.getShipmentDestination());
				drivershipmentData.setShipmentDate(driverShipment.getShipmentDate());
				drivershipmentData.setShipmentQuantity(driverShipment.getShipmentQuantity());
				drivershipmentData.setShipmentTypeId(driverShipment.getShipmentTypeId());
				drivershipmentData.setShipmentTypeName(driverShipment.getShipmentDetails().getMaterialName());
				drivershipmentData.setInDriver(driverShipment.getIndriver());
				drivershipmentData.setSecondDriver(
						driverShipment.getSecondDriverName() != null ? driverShipment.getSecondDriverName() : null);

				drivershipmentData.setKms(driverShipment.getKms());

				driverShipmentDataList.add(drivershipmentData);

			}
		}
		return driverShipmentDataList;
	}

	@Override
	public ResponseData updateShipment(Long shipmentId, DriverShimentPayload updateShipmentPayload) {
		ResponseData responseData = new ResponseData();
		Optional<DriverShipment> driverShipmentDetails = driverShipmentRepo.findById(shipmentId);

		if (driverShipmentDetails.isPresent()) {
			DriverShipment driverShipment = driverShipmentDetails.get();
			driverShipment.setCustomerId(updateShipmentPayload.getCustomerId());
			driverShipment.setShipmentSource(updateShipmentPayload.getSource());
			driverShipment.setShipmentDestination(updateShipmentPayload.getDestination());
			driverShipment.setShipmentTypeId(updateShipmentPayload.getShipmentTypeId());
			driverShipment.setShipmentQuantity(updateShipmentPayload.getShipmentQuantity());
			driverShipment.setShipmentTransTypeId(updateShipmentPayload.getShipmentTransTypeId());
			driverShipment.setShiftType(updateShipmentPayload.getShiftType());
			driverShipment.setIndriver(updateShipmentPayload.getInDriver());
			driverShipment.setSecondDriverName(updateShipmentPayload.getSecondDriver());
			driverShipment.setVehicleNumberId(updateShipmentPayload.getVehicleId());

			DriverShipment savedDriverShipment = driverShipmentRepo.save(driverShipment);

			if (savedDriverShipment != null && savedDriverShipment.getId() != null) {
				responseData.setResult(true);
				responseData.setStatus("Success");
				responseData.setMessage("Successfully Saved");
			} else {
				responseData.setResult(false);
				responseData.setStatus("Failed");
				responseData.setMessage("Save operation failed");
			}

		}
		return responseData;

	}

	@Override
	public ResponseData deleteDriverShipment(Long shipmentId) {

		ResponseData responseData = new ResponseData();

		if (driverShipmentRepo.existsById(shipmentId)) {
			driverShipmentRepo.deleteById(shipmentId);
			responseData.setResult(true);
			responseData.setStatus("Success");
			responseData.setMessage("Successfully Deleted");
		} else {
			responseData.setResult(false);
			responseData.setStatus("Failed");
			responseData.setMessage("Delete operation failed");
		}

		return responseData;
	}
	
}
