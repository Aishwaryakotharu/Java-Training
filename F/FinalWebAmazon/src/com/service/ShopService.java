package com.service;

import java.util.List;

import com.model.Shop;

public interface ShopService {
	public  Shop get(int id);
	public  List<Shop> getAllShops();
	public  Shop findByName(String name);
	public  Boolean insertShop(Shop shopDto);
	public  Boolean deleteShop(Shop shopDto);
	public  int countShops();
	public  Shop nextShop(int id);
}
