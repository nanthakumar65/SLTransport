package com.example.demo.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ResponseData;
import com.example.demo.model.MaterialMaster;
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
		MaterialMaster saveMaterialMaster = materialMasterRepository.save(materialMaster);
		if(saveMaterialMaster != null) {
			responseData.setMessage("Successfully Saved");
			responseData.setResult(true);
			responseData.setStatus("Success");
		}
		return responseData;
	}

	@Override
	public ResponseData updateMaterial(MaterialMasterPayload materialMasterPayload) {
		ResponseData responseData = new ResponseData();
		MaterialMaster materialMaster = new MaterialMaster();
		materialMaster.setMaterialName(materialMasterPayload.getMaterialName());
		Optional<MaterialMaster> materialMasterById = materialMasterRepository.findById(materialMaster.getMaterialId());
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
		return null;
	}

	
}
