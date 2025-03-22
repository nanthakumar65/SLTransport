package com.example.demo.data;

import lombok.Data;

@Data
public class ResponseData {

	private Boolean result = false;
	
	private String status = "Failed";
	
	private String message;
}
