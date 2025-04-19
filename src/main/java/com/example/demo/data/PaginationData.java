package com.example.demo.data;

import java.util.List;

import lombok.Data;

@Data
public class PaginationData {

	private Long totalCount;
	
	private List<?> list;
}
