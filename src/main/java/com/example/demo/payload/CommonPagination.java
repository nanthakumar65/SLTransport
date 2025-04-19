package com.example.demo.payload;

import lombok.Data;

@Data
public class CommonPagination {

	private Long pageNo;
	
	private Long pageSize;
	
	private Long isActive;
	
	private String searchKey;
}
