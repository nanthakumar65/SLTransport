package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DriverExpense;

@Repository
public interface DriverExpenseRepo extends JpaRepository<DriverExpense, Long>{

}
