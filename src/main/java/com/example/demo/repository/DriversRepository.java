package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Drivers;

public interface DriversRepository extends JpaRepository<Drivers, Long>{
	
	
	Page<Drivers> findByNameOrMobileNumberOrFatherName(String name, String mobileNo, String fatherName, Pageable pageable);
	
		

}
