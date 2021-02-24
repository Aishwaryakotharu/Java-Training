package com.dao;

import java.util.List;

import com.model.Shop;

public abstract class ShopDAO {

	public abstract Shop get(int id);
	public abstract List<Shop> getAllShops();
	public abstract Shop findByName(String name);
	public abstract Boolean insertShop(Shop shopDto);
	public abstract Boolean deleteShop(Shop shopDto);
	public abstract int countShops();
	public abstract Shop nextShop(int id);
}
