package com.example.demo.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Util.DateUtil;
import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.model.MaterialMaster;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.MaterialMasterPayload;
import com.example.demo.repository.MaterialMasterRepository;
import com.example.demo.service.MaterialMasterService;

@Service
public class MaterialMasterServiceImpl implements MaterialMasterService{
	
	@Autowired
	private MaterialMasterRepository materialMasterRepository;

	@Override
	public ResponseData saveMaterialMasterDetails(MaterialMasterPayload materialMasterPayload) {
		ResponseData responseData = new ResponseData();
		
		MaterialMaster materialMaster  = new MaterialMaster();
		materialMaster.setMaterialName(materialMasterPayload.getMaterialName());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String formattedDate = sdf.format(new Date());
	      MaterialMaster saveMaterialMaster = materialMasterRepository.save(materialMaster);
		if(saveMaterialMaster != null) {
			responseData.setMessage("Successfully Saved");
			responseData.setResult(true);
			responseData.setStatus("Success");
		}
		return responseData;
	}

	@Override
	public ResponseData updateMaterial(Long materialId, MaterialMasterPayload materialMasterPayload) {
		ResponseData responseData = new ResponseData();
		MaterialMaster materialMaster = new MaterialMaster();
		materialMaster.setMaterialName(materialMasterPayload.getMaterialName());
		Optional<MaterialMaster> materialMasterById = materialMasterRepository.findById(materialId);
		if (materialMasterById.isPresent()) {
			responseData.setMessage("Successfully Updated");
			responseData.setResult(true);
			responseData.setStatus("Success");
			return responseData;
		}
		responseData.setMessage("Updated Failed");
		return responseData;
	}

	@Override
	public ResponseData deleteMaterialById(Long materialId) {
		ResponseData responseData = new ResponseData();
		materialMasterRepository.deleteById(materialId);
		responseData.setMessage("Deleted Successfully");
		responseData.setResult(true);
		responseData.setStatus("Success");
		return responseData;
	}

	@Override
	public PaginationData getMaterials(CommonPagination commonPagination) {
		PaginationData paginationData = new PaginationData();
		Pageable pageable = PageRequest.of(commonPagination.getPageNo().intValue(), commonPagination.getPageSize().intValue());
		long count = materialMasterRepository.count();
		Page<MaterialMaster> materialMaster = materialMasterRepository.findAll(pageable);
		List<MaterialMaster> content = materialMaster.getContent();
		if(!content.isEmpty() && content !=null) {
			paginationData.setList(content);
			paginationData.setTotalCount(count);
			return paginationData;
		}
		return null;
	}

	
}
