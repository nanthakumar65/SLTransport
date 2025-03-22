package com.example.demo.service.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.Customers;
import com.example.demo.model.VehicleEntry;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.VehiclePayload;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleInterface;

@Service
public class VehicleServiceImpl implements VehicleInterface {

	@Autowired
	private VehicleRepository vehicleRepo;

	@Override
	public ResponseData saveVechileDetails(VehiclePayload saveVechilePayload) {
		VehicleEntry vechileEntry = new VehicleEntry();
		vechileEntry.setVehicleNumber(saveVechilePayload.getVehicleNumber());
		vechileEntry.setFcValidUpto(saveVechilePayload.getFcValidUpto());
		vechileEntry.setInsuranceValidUpto(saveVechilePayload.getInsuranceValidUpto());
		vechileEntry.setFastagDetails(saveVechilePayload.getFastagDetails());
		vechileEntry.setNoOfWheels(saveVechilePayload.getNoOfWheels());
		vechileEntry.setNpValidUpto(saveVechilePayload.getNpValidUpto());
		vechileEntry.setOwnerName(saveVechilePayload.getOwnerName());
		vechileEntry.setPermitValidUpto(saveVechilePayload.getPermitValidUpto());
		vechileEntry.setPuccValidUpto(saveVechilePayload.getPuccValidUpto());
		vechileEntry.setRegistrationDate(saveVechilePayload.getRegistrationDate());
		vechileEntry.setRtoOffice(saveVechilePayload.getRtoOffice());
		vechileEntry.setTaxValidUpto(saveVechilePayload.getTaxValidUpto());
		vechileEntry.setVehicleClass(saveVechilePayload.getVehicleClass());
		vechileEntry.setEngineNumber(saveVechilePayload.getEngineNumber());
		vechileEntry.setChassisNumber(saveVechilePayload.getChassisNumber());
		vechileEntry.setBrandName(saveVechilePayload.getBrandName());
		VehicleEntry saveVehicleEntry = vehicleRepo.save(vechileEntry);

		ResponseData responseData = new ResponseData();

		if (saveVehicleEntry != null) {
			responseData.setMessage("Vechile Details Saved Successfully");
			responseData.setStatus("Success");
			responseData.setResult(true);
		} else {
			responseData.setMessage("Error Occured While Saving Vechile Details");
		}

		return responseData;

	}

	@Override
	public ResponseData updateVechileDetails(Long vehicleId, VehiclePayload updateVechilePayload) {

		Optional<VehicleEntry> optionalVechileEntry = vehicleRepo.findById(vehicleId);
		ResponseData responseData = new ResponseData();
		if (optionalVechileEntry.isPresent()) {

			VehicleEntry vechileEntry = optionalVechileEntry.get();

			vechileEntry.setVehicleNumber(updateVechilePayload.getVehicleNumber());
			vechileEntry.setFcValidUpto(updateVechilePayload.getFcValidUpto());
			vechileEntry.setInsuranceValidUpto(updateVechilePayload.getInsuranceValidUpto());
			vechileEntry.setFastagDetails(updateVechilePayload.getFastagDetails());
			vechileEntry.setNoOfWheels(updateVechilePayload.getNoOfWheels());
			vechileEntry.setNpValidUpto(updateVechilePayload.getNpValidUpto());
			vechileEntry.setOwnerName(updateVechilePayload.getOwnerName());
			vechileEntry.setPermitValidUpto(updateVechilePayload.getPermitValidUpto());
			vechileEntry.setPuccValidUpto(updateVechilePayload.getPuccValidUpto());
			vechileEntry.setRegistrationDate(updateVechilePayload.getRegistrationDate());
			vechileEntry.setRtoOffice(updateVechilePayload.getRtoOffice());
			vechileEntry.setTaxValidUpto(updateVechilePayload.getTaxValidUpto());
			vechileEntry.setVehicleClass(updateVechilePayload.getVehicleClass());
			vechileEntry.setEngineNumber(updateVechilePayload.getEngineNumber());
			vechileEntry.setChassisNumber(updateVechilePayload.getChassisNumber());
			vechileEntry.setBrandName(updateVechilePayload.getBrandName());
			VehicleEntry saveVehicleEntry = vehicleRepo.save(vechileEntry);

			if (saveVehicleEntry != null) {
				responseData.setMessage("Saved Successfully");
				responseData.setStatus("Success");
				responseData.setResult(true);
			} else {
				responseData.setMessage("Saved Failed");
			}

		}

		return responseData;

	}

	@Override
	public ResponseData deleteVehicleDetails(Long vehicleId) {
		ResponseData responseData = new ResponseData();
		if (vehicleRepo.existsById(vehicleId)) {
			vehicleRepo.deleteById(vehicleId);
			responseData.setMessage("Deleted Successfully");
			responseData.setResult(true);
			responseData.setStatus("Success");

		} else {
			responseData.setMessage("Deleted Failed");
		}
		return responseData;
	}

	@Override
	public PaginationData getVechileList(CommonPagination commonPagination) {
		PaginationData paginationData = new PaginationData();
		Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(),
				commonPagination.getPageSize().intValue());
		Page<VehicleEntry> PageVechileList = vehicleRepo.findAll(pageable);
		List<VehicleEntry> VechileList = PageVechileList.getContent();
		if (!VechileList.isEmpty() && VechileList != null) {
			paginationData.setList(VechileList);
			paginationData.setTotalCount(VechileList.size());
			return paginationData;
}
		return null;
		

}
}
