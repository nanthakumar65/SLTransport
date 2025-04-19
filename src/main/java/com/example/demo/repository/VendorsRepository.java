package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Vendors;

public interface VendorsRepository extends JpaRepository<Vendors, Long>{

}
