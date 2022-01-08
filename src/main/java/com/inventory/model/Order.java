package com.inventory.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="order_detail")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private LocalDateTime orderDate;
	private LocalDateTime billDate;
	private BigDecimal totalAmount;
	private BigDecimal paidAmount;
	private BigDecimal balanceAmount;

	private Long customerId;
	private Long loginId;
	private String remarks;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private Set<OrderDetails> orderDetails;
}