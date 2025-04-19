package com.example.demo.service;

import com.example.demo.data.PaginationData;
import com.example.demo.data.ResponseData;
import com.example.demo.payload.CommonPagination;
import com.example.demo.payload.VendorPayload;

public interface VendorsService {

	 ResponseData saveVendor(VendorPayload vendorPayload);

	 PaginationData getVendors(CommonPagination commonPagination);

	 ResponseData deleteVendors(Long vendorId);

	void updateVendor( Long vendorId, VendorPayload vendorPayload);

}
