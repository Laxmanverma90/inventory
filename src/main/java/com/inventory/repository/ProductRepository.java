package com.inventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByAvailability(Integer availability);
}
