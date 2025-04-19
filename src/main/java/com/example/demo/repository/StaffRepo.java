package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff,Long>{

	Optional<Staff> findByUserName(String userName);

}
