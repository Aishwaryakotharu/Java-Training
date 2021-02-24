package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.ItemDAOImpl;
import com.model.Item;
import com.model.Shop;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDAOImpl itemDAOImpl;
	private static ItemServiceImpl itemdao_instance;

	public static ItemServiceImpl getInstance() {
		if (itemdao_instance == null)
			itemdao_instance = new ItemServiceImpl();
		return itemdao_instance;
	}

	@Override
	public Item findByName(String name) {
		Item res=itemDAOImpl.findByName(name);
		return res;
	}

	@Override
	public Item getitem(String id) {
		Item res=itemDAOImpl.getitem(id);
		return res;
	}

	@Override
	public List<Item> getAllItems(Shop shop) {
		List<Item> res=itemDAOImpl.getAllItems(shop);
		return res;
	}

	@Override
	public Boolean insertItem(Item itemDto) {
		Boolean res=itemDAOImpl.insertItem(itemDto);
		return res;
	}

	@Override
	public Boolean updateItem(Item itemDto) {
		Boolean res=itemDAOImpl.updateItem(itemDto);
		return res;
	}

	@Override
	public Boolean deleteItem(Item itemDto) {
		Boolean res=itemDAOImpl.deleteItem(itemDto);
		return res;
	}
	
}
