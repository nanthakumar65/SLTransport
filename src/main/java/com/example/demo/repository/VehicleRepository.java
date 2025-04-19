package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.VehicleEntry;


@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntry, Long>{

	Page<VehicleEntry> findByVehicleNumberOrOwnerNameOrBrandName(String vehicleNo, String ownerName, String brand, Pageable pageable);
}
