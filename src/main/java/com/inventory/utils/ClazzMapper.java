package com.inventory.utils;

import java.util.List;

import org.mapstruct.Mapper;

import com.inventory.dto.CustomerDto;
import com.inventory.dto.ItemDto;
import com.inventory.dto.OrderBillDto;
import com.inventory.dto.ProductDto;
import com.inventory.model.Customer;
import com.inventory.model.Item;
import com.inventory.model.OrderBill;
import com.inventory.model.Product;

@Mapper(componentModel = "spring")
public interface ClazzMapper {

	List<ProductDto> productToDto(List<Product> product);

	ProductDto productToProductDto(Product product);

	ItemDto itemToItemDto(Item item);

	List<ItemDto> itemsToItemDto(List<Item> items);

	List<Item> itemsDtoToItems(List<ItemDto> items);

	CustomerDto customerToCustomerDto(Customer customer);

	Customer customerDtoToCustomer(CustomerDto customerDto);

	List<OrderBillDto> orderBillToOrderBillDto(List<OrderBill> orderBills);
}
