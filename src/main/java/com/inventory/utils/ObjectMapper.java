package com.inventory.utils;

import java.util.List;

import org.mapstruct.Mapper;

import com.inventory.dto.ProductRateDto;
import com.inventory.model.ProductRateDao;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

	ProductRateDto productRateDaoToDto(ProductRateDao productRateDao);

	List<ProductRateDto> productRateListDaoToDto(List<ProductRateDao> productRateDaos);
}
