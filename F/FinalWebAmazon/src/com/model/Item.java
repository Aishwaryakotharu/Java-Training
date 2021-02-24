package com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Item")
@Table(name = "items")

@SuppressWarnings("serial")
public class Item implements Serializable, Comparable<Item>{
	
public Item() {
	// TODO Auto-generated constructor stub
}
@Id
	private int id,price;
	private String name,unit,imageUrl ="https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
	private Shop shop;
	
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Item(int id, String name, String unit, int price, String imageUrl, Shop shop) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.shop = shop;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + price;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", unit = " + unit + ", shop" + shop.toString() + ", price"
				+ price + ", image_url" + imageUrl + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
