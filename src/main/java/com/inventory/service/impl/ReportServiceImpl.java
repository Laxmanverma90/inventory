package com.inventory.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.CustomerDto;
import com.inventory.dto.OrderBillDetailDto;
import com.inventory.dto.OrderBillDto;
import com.inventory.dto.report.CustomerReportDto;
import com.inventory.dto.report.ItemReportDto;
import com.inventory.exception.CustomerNotFoundException;
import com.inventory.model.LoginDetails;
import com.inventory.model.Order;
import com.inventory.model.OrderBill;
import com.inventory.repository.BillDetailRepository;
import com.inventory.repository.CustomerRepository;
import com.inventory.repository.LoginRepository;
import com.inventory.repository.SaleItemRepository;
import com.inventory.service.ReportService;
import com.inventory.utils.ClazzMapper;
import com.inventory.utils.CustomerMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

	private final CustomerRepository customerRepository;
	private final BillDetailRepository billDetailRepository;
	private final SaleItemRepository saleItemRepository;
	private final LoginRepository loginRepository;
	private final ClazzMapper clazzMapper;
	private final CustomerMapper customerMapper;

	@Override
	public ItemReportDto getItemReport(String fromDate, String toDate, Long userId) {

		
		List<Long> orderIdList = new ArrayList<>();
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal balanceAmount = new BigDecimal(0);
		BigDecimal paidAmount = new BigDecimal(0);

		List<Order> orders = getOrderReport(fromDate, toDate, userId);

		for (Order order : orders) {
			totalAmount = totalAmount.add(order.getTotalAmount());
			paidAmount = paidAmount.add(order.getPaidAmount());
			balanceAmount = balanceAmount.add(order.getBalanceAmount());
			orderIdList.add(order.getOrderId());
		}
		List<OrderBill> orderBills = saleItemRepository.getAllDetailByOrderIdList(orderIdList);
		List<OrderBillDto> orderBillsDto = clazzMapper.orderBillToOrderBillDto(orderBills);

		return ItemReportDto.builder().fromDate(LocalDate.parse(fromDate)).fromDate(LocalDate.parse(toDate))
				.totalAmount(totalAmount).balanceAmount(balanceAmount).paidAmount(paidAmount)
				.orderBillDto(orderBillsDto).build();
	}

	@Override
	public CustomerReportDto getReportByCustomer(String fromDate, String toDate, String mobileNumber) {

		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal balanceAmount = new BigDecimal(0);
		BigDecimal paidAmount = new BigDecimal(0);

		CustomerDto customerDto = customerMapper
				.customerToCustomerDto(customerRepository.findByMobileNumber(mobileNumber.trim()));
		if(customerDto==null) {
			throw new CustomerNotFoundException();
		}
		List<LoginDetails> loginDetails = loginRepository.findAll();
		Map<Long, String> map = loginDetails.stream()
				.collect(Collectors.toMap(LoginDetails::getLoginId, LoginDetails::getName));

		List<OrderBillDetailDto> orderBillsDetailDto = new ArrayList<>();
		List<Order> orders = getOrderByCustomer(fromDate, toDate, customerDto.getCustomerId());

		for (Order order : orders) {
			orderBillsDetailDto.add(getOrderBillDetail(order, map));
			totalAmount = totalAmount.add(order.getTotalAmount());
			paidAmount = paidAmount.add(order.getPaidAmount());
			balanceAmount = balanceAmount.add(order.getBalanceAmount());
		}
		return CustomerReportDto.builder().totalAmount(totalAmount).paidAmount(paidAmount).balanceAmount(balanceAmount)
				.customerDto(customerDto).orderBillsDetailDto(orderBillsDetailDto).build();
	}
	
	private List<Order> getOrderReport(String fromDate, String toDate, Long userId){
		
		List<Order> orders = null;
		if ((toDate == null || toDate.isEmpty()) && userId == null) {
			orders = billDetailRepository.findByBillDateBetween(LocalDate.parse(fromDate).atStartOfDay(),
					LocalDate.now().atStartOfDay().plusDays(1));
		} else if (userId == null) {
			orders = billDetailRepository.findByBillDateBetween(LocalDate.parse(fromDate).atStartOfDay(),
					LocalDate.parse(toDate).atStartOfDay().plusDays(1));
		} else if ((toDate == null || toDate.isEmpty())) {
			orders = billDetailRepository.findByLoginIdAndBillDateBetween(userId,
					LocalDate.parse(fromDate).atStartOfDay(), LocalDate.now().atStartOfDay().plusDays(1));
		} else {
			orders = billDetailRepository.findByLoginIdAndBillDateBetween(userId,
					LocalDate.parse(fromDate).atStartOfDay(), LocalDate.parse(toDate).atStartOfDay().plusDays(1));
		}
		return orders;
	}

	private List<Order> getOrderByCustomer(String fromDate, String toDate, Long customerId) {

		List<Order> orders = null;
		if (toDate == null || toDate.isEmpty()) {
			orders = billDetailRepository.findByCustomerIdAndBillDateBetween(customerId,
					LocalDate.parse(fromDate).atStartOfDay(), LocalDate.now().atStartOfDay().plusDays(1));
		} else {
			orders = billDetailRepository.findByLoginIdAndBillDateBetween(customerId,
					LocalDate.parse(fromDate).atStartOfDay(), LocalDate.parse(toDate).atStartOfDay().plusDays(1));
		}
		return orders;
	}

	private OrderBillDetailDto getOrderBillDetail(Order order, Map<Long, String> map) {
		return OrderBillDetailDto.builder().orderId(order.getOrderId()).totalAmount(order.getTotalAmount())
				.paidAmount(order.getPaidAmount()).balanceAmount(order.getBalanceAmount())
				.orderDate(order.getOrderDate().toLocalDate()).billDate(order.getBillDate().toLocalDate())
				.biller(map.get(order.getLoginId())).remarks(order.getRemarks()).build();
	}

}
