package com.example.demo.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DriverShipment;

public interface DriverShipmentRepository extends JpaRepository<DriverShipment, Long>{

//	Page<DriverShipment> findAll(Pageable pageable);

}
