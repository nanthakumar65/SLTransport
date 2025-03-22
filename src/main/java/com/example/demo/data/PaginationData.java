package com.example.demo.data;

import java.util.List;

import lombok.Data;

@Data
public class PaginationData {

	private Integer totalCount;
	
	private List<?> list;
}
