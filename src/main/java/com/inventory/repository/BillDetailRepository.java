package com.inventory.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.Order;

public interface BillDetailRepository extends JpaRepository<Order, Long> {

	List<Order> findByBillDateBetween(LocalDateTime fromDate, LocalDateTime toDate);
	
	List<Order> findByLoginIdAndBillDateBetween(Long loginId, LocalDateTime fromDate, LocalDateTime toDate);
	
	List<Order> findByCustomerIdAndBillDateBetween(Long customerId, LocalDateTime fromDate, LocalDateTime toDate);
}