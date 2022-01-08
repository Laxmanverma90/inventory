package com.inventory.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderBillRepository{} /*extends JpaRepository<OrderBill, Long> {

	String FIND_ORDER_DETAILS = "SELECT od.id AS orderItemId, it.product_id AS productId, p.product_name AS productName, "
			+ "od.item_id AS itemId, it.item AS itemName, od.rate AS rate, od.quantity AS quantity, od.amount AS amount "
			+ "FROM inventory.order_item_detail od, inventory.item it, inventory.product p "
			+ "WHERE od.item_id=it.item_id AND p.product_id=it.product_id AND od.order_id= :orderId ";

	@Query(value = FIND_ORDER_DETAILS, nativeQuery = true)
	List<OrderBill> getAllDetailByOrderId(Long orderId);
}*/
