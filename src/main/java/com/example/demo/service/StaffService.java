package com.example.demo.service;

import com.example.demo.data.ResponseData;
import com.example.demo.payload.StaffPayload;

public interface StaffService {

	ResponseData saveStaffDetails(StaffPayload staffPayload);

}
