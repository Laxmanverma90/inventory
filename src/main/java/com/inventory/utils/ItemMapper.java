package com.inventory.utils;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inventory.dto.ItemDto;
import com.inventory.model.Item;

@Mapper(componentModel = "spring")
public interface ItemMapper {
	
	ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
	
	ItemDto itemToItemDto(Item item);
	Item itemDtoToItem(ItemDto itemDto);
	
	List<ItemDto> itemsToItemsDto(List<Item> items);
	List<Item> itemsDtoToItems(List<ItemDto> itemsDto);
}