package com.inventory.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.ProductRateDto;
import com.inventory.model.ProductRateDao;
import com.inventory.service.ProductService;
import com.inventory.utils.ObjectMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public List<ProductRateDto> getProduct() {
		List<ProductRateDto> dtoList;
		List<ProductRateDao> daoList = new ArrayList<>();
		ProductRateDao productRateDao = ProductRateDao.builder()
				.availability("1")
				.id(1)
				.item("200ml")
				.rate(new BigDecimal(100))
				.productId(101)
				.build();
		ProductRateDao productRateDao1 = ProductRateDao.builder()
				.availability("11")
				.id(1)
				.item("200ml")
				.rate(new BigDecimal(100))
				.productId(101)
				.build();
		daoList.add(productRateDao);
		daoList.add(productRateDao1);
		dtoList =objectMapper.productRateListDaoToDto(daoList);
		 
		 return dtoList;
	}

	@Override
	public List<ProductRateDto> updateProductsRate(List<ProductRateDto> products) {
		// TODO Auto-generated method stub
		return null;
	}

}
