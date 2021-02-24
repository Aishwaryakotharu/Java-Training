package com.service;

import java.util.List;

import com.model.Item;
import com.model.Shop;

public interface ItemService {
	public  Item findByName(String name);
	public  Item getitem(String id);
	public  List<Item> getAllItems(Shop shop);
	public  Boolean insertItem(Item itemDto);
	public  Boolean updateItem(Item itemDto);
	public  Boolean deleteItem(Item itemDto);

}
