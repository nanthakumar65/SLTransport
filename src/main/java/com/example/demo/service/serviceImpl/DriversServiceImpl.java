package com.example.demo.service.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Util.DateUtil;
import com.example.demo.data.AllDriversData;
import com.example.demo.data.DriversNameData;
import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.Drivers;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.NewDriverPayload;
import com.example.demo.repository.DriversRepository;
import com.example.demo.service.DriversService;

@Service
public class DriversServiceImpl implements DriversService{
	
	@Autowired
	private DriversRepository driversRepo;

	@Override
	public ResponseData saveDriverDetails(NewDriverPayload driverDataPayload) {
		ResponseData responseData = new ResponseData();
		Drivers drivers = new Drivers();
		drivers.setName(driverDataPayload.getDriverName());
		drivers.setFatherName(driverDataPayload.getFatherName());
		drivers.setMobileNumber(driverDataPayload.getMobileNumber());
		drivers.setDob(DateUtil.convertDateFormat(driverDataPayload.getDob()));
		drivers.setAadharCardNo(driverDataPayload.getAadharCard());
		drivers.setLicenseNumber(driverDataPayload.getLicenseNumber());
		drivers.setNtExpiry(driverDataPayload.getNtExpiry());
		drivers.setTExpiry(driverDataPayload.getTexpiry());
		drivers.setAccNumber(driverDataPayload.getAccNumber());
		drivers.setAccHolderName(driverDataPayload.getAccHolderName());
		drivers.setBankName(driverDataPayload.getBankName());
		drivers.setIfscCode(driverDataPayload.getIfscCode());
		drivers.setTemporaryAddress(driverDataPayload.getTemporaryAddress());
		drivers.setPermanentAddress(driverDataPayload.getPermanentAddress());
		drivers.setActive(driverDataPayload.getDriverStatus());
		
		Drivers saveDriver = driversRepo.save(drivers);
		if(saveDriver != null) {
			responseData.setMessage("Successfully Saved");
			responseData.setResult(true);
			responseData.setStatus("Success");
		}
		return responseData;
	}

	
	public PaginationData getDriversDetails(Long isActive, CommonPagination commonPagination) {
		PaginationData paginationData = new PaginationData();
		List<AllDriversData> allDriversDataList = new ArrayList<>();
		long count = driversRepo.count();
		List<Drivers> driverscontent = null;

		/** SEARCH **/
		if (commonPagination.getSearchKey() != null) {
			String searchKey = commonPagination.getSearchKey();
			Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(),
					commonPagination.getPageSize().intValue());
			Page<Drivers> drivers = driversRepo.findByNameOrMobileNumberOrFatherName(searchKey, searchKey, searchKey, pageable);
			driverscontent = drivers.getContent();
		}
		/** GET ALL DRIVERS **/
		else {
			Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(),
					commonPagination.getPageSize().intValue());
			Page<Drivers> drivers = driversRepo.findAll(pageable);
			driverscontent = drivers.getContent();
		}
		if (!driverscontent.isEmpty() && driverscontent != null) {
			for (Drivers driver : driverscontent) {
				Long active = driver.getActive() ? 1L : 0L;
				if (isActive == active) {
					getDriversByIsActive(allDriversDataList, driver);
				} else if (isActive == 2L) {
					getDriversByIsActive(allDriversDataList, driver);
				}
				paginationData.setList(allDriversDataList);
				paginationData.setTotalCount(count);
			}
		}
		return paginationData;
	}

	private void getDriversByIsActive(List<AllDriversData> allDriversDataList, Drivers driver) {
		AllDriversData allDriversData = new AllDriversData();
		allDriversData.setId(driver.getDriverId());
		allDriversData.setDriverName(driver.getName() + " -" + driver.getDriverId());
		allDriversData.setFatherName(driver.getFatherName());
		allDriversData.setMobileNumber(driver.getMobileNumber());
		allDriversData.setDob(driver.getDob());
		allDriversData.setAadharCard(driver.getAadharCardNo());
		allDriversData.setLicenseNumber(driver.getLicenseNumber());
		allDriversData.setNtExpiry(driver.getNtExpiry());
		allDriversData.setTExpiry(driver.getTExpiry());
		allDriversData.setAccNumber(driver.getAccNumber());
		allDriversData.setAccHolderName(driver.getAccHolderName());
		allDriversData.setBankName(driver.getBankName());
		allDriversData.setIfscCode(driver.getIfscCode());
		allDriversData.setTemporaryAddress(driver.getTemporaryAddress());
		allDriversData.setPermanentAddress(driver.getPermanentAddress());
		allDriversData.setDriverStatus(driver.getActive());
		Timestamp timestamp = Timestamp.valueOf(String.valueOf(driver.getCreatedDate()));
		LocalDate date = timestamp.toLocalDateTime().toLocalDate();
		allDriversData.setCreatedDate(date);
		if (driver.getNtExpiry() != null) {
			if (date.isEqual(LocalDate.now())) {
				allDriversData.setStatus("Expired");
			} else {
				allDriversData.setStatus("Active");
			}
		}
		allDriversDataList.add(allDriversData);
	}

	@Override
	public List<DriversNameData> getDriversName() {
		List<DriversNameData> driverNameList=new ArrayList<>();
		List<Drivers> driversList = driversRepo.findAll();
		if (!driversList.isEmpty() && driversList != null) {
			for (Drivers drivers : driversList) {
				DriversNameData driversNameData = new DriversNameData();
				driversNameData.setId(drivers.getDriverId());
				driversNameData.setDriverName(drivers.getName() + " -" + drivers.getDriverId());
				driverNameList.add(driversNameData);
			}
			
		}
		return driverNameList;
	}

	@Override
	public ResponseData deleteDriverById(Long driverId) {
		ResponseData responseData = new ResponseData();
		Optional<Drivers> driver = driversRepo.findById(driverId);
		if (driver.isPresent()) {
			driversRepo.deleteById(driverId);
			responseData.setMessage("Successfully Deleted");
			responseData.setResult(true);
			responseData.setStatus("Success");
		} else {
			responseData.setMessage("Not Deleted");
		}
		return responseData;
	}

	@Override
	public ResponseData updateDriversDetails(NewDriverPayload driverDataPayload, Long driverId) {

		ResponseData responseData = new ResponseData();
		
		Optional<Drivers> driver = driversRepo.findById(driverId);
		if (driver.isPresent()) {
			driver.get().setName(driverDataPayload.getDriverName());
			driver.get().setFatherName(driverDataPayload.getFatherName());
			driver.get().setMobileNumber(driverDataPayload.getMobileNumber());
			driver.get().setDob(DateUtil.convertDateFormat(driverDataPayload.getDob()));
			driver.get().setAadharCardNo(driverDataPayload.getAadharCard());
			driver.get().setLicenseNumber(driverDataPayload.getLicenseNumber());
			driver.get().setNtExpiry(driverDataPayload.getNtExpiry());
			driver.get().setTExpiry(driverDataPayload.getTexpiry());
			driver.get().setAccNumber(driverDataPayload.getAccNumber());
			driver.get().setAccHolderName(driverDataPayload.getAccHolderName());
			driver.get().setBankName(driverDataPayload.getBankName());
			driver.get().setIfscCode(driverDataPayload.getIfscCode());
			driver.get().setTemporaryAddress(driverDataPayload.getTemporaryAddress());
			driver.get().setPermanentAddress(driverDataPayload.getPermanentAddress());
			driver.get().setActive(driverDataPayload.getDriverStatus());
			Drivers saveDriver = driversRepo.save(driver.get());
			if (saveDriver != null) {
				responseData.setMessage("Updated Successfully");
				responseData.setResult(true);
				responseData.setStatus("Success");
			}
			else {
				responseData.setMessage("Updated Failed");
			}
		}
		return responseData;
	}
	
}
