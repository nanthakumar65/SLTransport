package com.example.demo.service.serviceImpl;

import java.time.LocalDate;
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
import com.example.demo.model.DriverExpense;
import com.example.demo.model.Drivers;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.DriverExpensePayload;
import com.example.demo.repository.DriverExpenseRepo;
import com.example.demo.repository.DriversRepository;
import com.example.demo.service.DriverExpenseService;

@Service
public class DriverExpenseImpl implements DriverExpenseService{

	@Autowired
	private DriverExpenseRepo driverExpenseRepo;
	
	@Autowired
	private DriversRepository driversRepository;
	
	@Override
	public ResponseData saveDriverExpense(DriverExpensePayload driverExpensePayload) {

		ResponseData responseData = new ResponseData();
		DriverExpense driverExpense = new DriverExpense();
		driverExpense.setDriverId(driverExpensePayload.getDriverId());
		Optional<Drivers> drivers = driversRepository.findById(driverExpensePayload.getDriverId());
		if(drivers.isPresent()) {
			driverExpense.setDriverName(drivers.get().getName());
		}
		driverExpense.setAdvance(driverExpensePayload.getAdvance());
		driverExpense.setDriverExpense(driverExpensePayload.getDriverExpense());
		driverExpense.setVehicleExpense(driverExpensePayload.getVehicleExpense());
		driverExpense.setDescription(driverExpensePayload.getDescription());
		driverExpense.setExpenseDate(driverExpensePayload.getExpenseDate());
		driverExpense.setCreatedDate(LocalDate.now());
		DriverExpense saveDriverExpense = driverExpenseRepo.save(driverExpense);
		if (saveDriverExpense != null) {
			responseData.setMessage("Saved Successfully");
			responseData.setStatus("Success");
			responseData.setResult(true);
			return responseData;
		} else {
			responseData.setMessage("Failed");
			return responseData;
		}
	}

	@Override
	public PaginationData getDriversExpense(CommonPagination commonPagination) {

		PaginationData paginationData = new PaginationData();
		Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(),
				commonPagination.getPageSize().intValue());
		Page<DriverExpense> driversExpense = driverExpenseRepo.findAll(pageable);
		List<DriverExpense> driversExpenseContent = driversExpense.getContent();
		if (driversExpenseContent != null) {
			paginationData.setList(driversExpenseContent);
			paginationData.setTotalCount(Long.valueOf(driversExpenseContent.size()));
			return paginationData;
		} else {
			paginationData.setList(Collections.emptyList());
			paginationData.setTotalCount(0L);
			return paginationData;
		}
	}

	@Override
	public ResponseData deleteDriverExpenseById(Long driverExpenseId) {
		
		ResponseData responseData = new ResponseData();
		if (driverExpenseRepo.existsById(driverExpenseId)) {
			driverExpenseRepo.deleteById(driverExpenseId);
			responseData.setMessage("Deleted Successfully");
			responseData.setResult(true);
			responseData.setStatus("Success");
			return responseData;
		} else {
			responseData.setMessage("Deleted Failed");
			return responseData;
		}
	}

	@Override
	public ResponseData updateDriverExpense(Long driverExpenseId, DriverExpensePayload driverExpensePayload) {

		ResponseData responseData = new ResponseData();
		Optional<DriverExpense> driverExpense = driverExpenseRepo.findById(driverExpenseId);
		if (driverExpense.isPresent()) {

			driverExpense.get().setDriverId(driverExpensePayload.getDriverId());
			Optional<Drivers> drivers = driversRepository.findById(driverExpensePayload.getDriverId());
			if (drivers.isPresent()) {
				driverExpense.get().setDriverName(drivers.get().getName());
			}
			driverExpense.get().setAdvance(driverExpensePayload.getAdvance());
			driverExpense.get().setDriverExpense(driverExpensePayload.getDriverExpense());
			driverExpense.get().setVehicleExpense(driverExpensePayload.getVehicleExpense());
			driverExpense.get().setDescription(driverExpensePayload.getDescription());
			driverExpense.get().setExpenseDate(driverExpensePayload.getExpenseDate());
			driverExpense.get().setCreatedDate(LocalDate.now());
			DriverExpense saveDriverExpense = driverExpenseRepo.save(driverExpense.get());
			if (saveDriverExpense != null) {
				responseData.setMessage("Saved Successfully");
				responseData.setStatus("Success");
				responseData.setResult(true);
				return responseData;
			}
		} else {
			responseData.setMessage("Failed");
			return responseData;
		}
		return responseData;
	}

}
