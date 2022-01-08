package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.LoginDetails;

public interface LoginRepository extends JpaRepository<LoginDetails, Long> {

	LoginDetails findByUserName(String userName);
}