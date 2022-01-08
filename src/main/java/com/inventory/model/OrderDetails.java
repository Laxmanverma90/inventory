package com.inventory.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="order_item_detail")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long itemId;
	private Integer quantity;
	private BigDecimal rate;
	private BigDecimal amount;
	private Long orderId;
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Order order;
	
	@OneToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId",insertable = false, updatable = false)
    private Item item;
}