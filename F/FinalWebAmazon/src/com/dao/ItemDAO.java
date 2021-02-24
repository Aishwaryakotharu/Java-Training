package com.dao;

import java.util.List;

import com.model.Item;
import com.model.Shop;

public abstract class ItemDAO {
	
	public abstract Item findByName(String name);
	public abstract Item getitem(String id);
	public abstract List<Item> getAllItems(Shop shop);
	public abstract Boolean insertItem(Item itemDto);
	public abstract Boolean updateItem(Item itemDto);
	public abstract Boolean deleteItem(Item itemDto);

}
