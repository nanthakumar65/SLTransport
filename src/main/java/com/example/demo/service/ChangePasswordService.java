package com.example.demo.service;

import com.example.demo.data.ResponseData;
import com.example.demo.payload.ChangePasswordPayload;

public interface ChangePasswordService {

	ResponseData changePassword(ChangePasswordPayload changePaswwordPayload);

}
