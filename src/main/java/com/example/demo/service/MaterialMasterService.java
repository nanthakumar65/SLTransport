package com.example.demo.service;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.MaterialMasterPayload;

public interface MaterialMasterService {

	public ResponseData saveMaterialMasterDetails(MaterialMasterPayload materialMasterPayload);

	public ResponseData updateMaterial(Long materialId, MaterialMasterPayload materialMasterPayload);

	public ResponseData deleteMaterialById(Long materialId);

	public PaginationData getMaterials(CommonPagination commonPagination);

}
