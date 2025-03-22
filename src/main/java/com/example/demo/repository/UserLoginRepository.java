package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin,Long >{

	Optional<UserLogin> findByUserEmailAndUserPsw(String userName, String UserPsw);
}
