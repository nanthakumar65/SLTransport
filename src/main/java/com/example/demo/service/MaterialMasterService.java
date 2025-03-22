package com.example.demo.service;

import com.example.demo.data.ResponseData;
import com.example.demo.payload.MaterialMasterPayload;

public interface MaterialMasterService {

	public ResponseData saveMaterialMasterDetails(MaterialMasterPayload materialMasterPayload);

	public ResponseData updateMaterial(MaterialMasterPayload materialMasterPayload);

	public ResponseData deleteMaterialById(Long materialId);

}
