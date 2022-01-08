package com.inventory.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.CustomerBillDetailDto;
import com.inventory.dto.CustomerDto;
import com.inventory.dto.OrderBillDetailDto;
import com.inventory.dto.OrderBillDto;
import com.inventory.dto.OrderDto;
import com.inventory.dto.ProductDto;
import com.inventory.exception.CustomerDataNotSaved;
import com.inventory.model.Customer;
import com.inventory.model.Order;
import com.inventory.model.OrderBill;
import com.inventory.repository.BillDetailRepository;
import com.inventory.repository.CustomerRepository;
import com.inventory.repository.SaleItemRepository;
import com.inventory.service.DailySaleService;
import com.inventory.service.ProductService;
import com.inventory.utils.ClazzMapper;
import com.inventory.utils.CustomerMapper;
import com.inventory.utils.OrderMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DailySaleServiceImpl implements DailySaleService {

	private final ClazzMapper clazzMapper;
	private final CustomerMapper customerMapper;
	private final OrderMapper orderMapper;
	private final ProductService productService;
	private final CustomerRepository customerRepository;
	private final BillDetailRepository billDetailRepository;
	private final SaleItemRepository saleItemRepository;

	/*
	 * @Autowired private OrderBillRepository orderBillRepository;
	 */

	@Override
	public List<ProductDto> getProduct() {
		return productService.getAvailableProduct();
	}

	@Override
	public CustomerDto getCustomer(String mobileNumber) {

		return clazzMapper.customerToCustomerDto(customerRepository.findByMobileNumber(mobileNumber));
	}

	@Override
	public CustomerBillDetailDto saveBillDetail(OrderDto orderDto) {

		Order order = orderMapper.OrderDtoToOrder(orderDto);
		if (orderDto.getCustomerDto().getCustomerId() != null) {
			order.setCustomerId(orderDto.getCustomerDto().getCustomerId());
		} else {
			Customer customer = customerMapper.customerDtoToCustomer(orderDto.getCustomerDto());
			customer.setAvailability(1);
			customer.setUpdateDate(LocalDate.now());
			Customer savedCustomer = customerRepository.save(customer);
			if (savedCustomer == null) {
				throw new CustomerDataNotSaved();
			}
			order.setCustomerId(savedCustomer.getCustomerId());
		}
		order.setBillDate(LocalDateTime.now());
		order.setOrderDate(LocalDateTime.now());
		Order savedOrder = billDetailRepository.save(order);

		CustomerBillDetailDto customerBillDetailDto = new CustomerBillDetailDto();

		List<OrderBill> orderBill = saleItemRepository.getAllDetailByOrderId(savedOrder.getOrderId());
		customerBillDetailDto.setOrderBillDetailDto(getOrderBillDetail(savedOrder));
		customerBillDetailDto.setOrderBillDto(clazzMapper.orderBillToOrderBillDto(orderBill));
		customerBillDetailDto.setCustomerDto(getCustomer(savedOrder.getCustomerId()));

		return customerBillDetailDto;
	}

	private OrderBillDetailDto getOrderBillDetail(Order savedOrder) {

		OrderBillDetailDto orderBillDetailDto = new OrderBillDetailDto();
		orderBillDetailDto.setOrderId(savedOrder.getOrderId());
		orderBillDetailDto.setOrderDate(savedOrder.getOrderDate().toLocalDate());
		orderBillDetailDto.setBillDate(savedOrder.getBillDate().toLocalDate());
		orderBillDetailDto.setTotalAmount(savedOrder.getTotalAmount());
		orderBillDetailDto.setBalanceAmount(savedOrder.getBalanceAmount());
		orderBillDetailDto.setRemarks(savedOrder.getRemarks());
		// orderBillDetailDto.setBiller(customerRepository.findByCustomerId(savedOrder.getCustomerId()).);

		return orderBillDetailDto;
	}

	/*
	 * public List<OrderBillDto> getOrderBills(List<OrderBill> orderBill) {
	 * 
	 * List<OrderBillDto> orderBillDtoList = new ArrayList<>();
	 * 
	 * for (OrderBill orderBillData : orderBill) { OrderBillDto orderBillDto = new
	 * OrderBillDto(); orderBillDto.setOrderItemId(orderBillData.getOrderItemId());
	 * orderBillDto.setItemId(orderBillData.getItemId());
	 * orderBillDto.setItemName(orderBillData.getItemName());
	 * orderBillDto.setProductId(orderBillData.getProductId());
	 * orderBillDto.setProductName(orderBillData.getProductName());
	 * orderBillDto.setRate(orderBillData.getRate());
	 * orderBillDto.setQuantity(orderBillData.getQuantity());
	 * orderBillDto.setAmount(orderBillData.getAmount());
	 * orderBillDtoList.add(orderBillDto); } return orderBillDtoList; }
	 */

	private CustomerDto getCustomer(Long customerId) {
		return customerMapper.customerToCustomerDto(customerRepository.findByCustomerId(customerId));
	}
}