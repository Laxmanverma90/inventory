package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.model.OrderBill;
import com.inventory.model.OrderDetails;

public interface SaleItemRepository extends JpaRepository<OrderDetails, Long> {

	String QUERY_FIND_ORDER_DETAILS = "SELECT new com.inventory.model.OrderBill(od.id, it.productId, p.productName, "
			+ "od.itemId, it.item, od.rate, od.quantity, od.amount) FROM OrderDetails as od inner join Item as it "
			+ "on od.itemId=it.itemId inner join Product as p on it.productId=p.productId AND od.orderId= :orderId";
	
	String QUERY_FIND_ORDER_DETAILS_BY_ORDERIDS = "SELECT new com.inventory.model.OrderBill(od.id, it.productId, p.productName, "
			+ "od.itemId, it.item, od.rate, od.quantity, od.amount) FROM OrderDetails as od inner join Item as it "
			+ "on od.itemId=it.itemId inner join Product as p on it.productId=p.productId AND od.orderId in :ordersId";

	List<OrderDetails> findByIdIn(List<Long> ids);

	@Query(QUERY_FIND_ORDER_DETAILS)
	List<OrderBill> getAllDetailByOrderId(Long orderId);
	
	@Query(QUERY_FIND_ORDER_DETAILS_BY_ORDERIDS)
	List<OrderBill> getAllDetailByOrderIdList(List<Long> ordersId);
}