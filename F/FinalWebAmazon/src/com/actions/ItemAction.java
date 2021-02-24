package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Item;
import com.dao.ItemDAOImpl;
import com.dao.ShopDAOImpl;

public class ItemAction  extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Item item = new Item();
		item.setName(request.getParameter("name"));
		item.setUnit(request.getParameter("unit"));
		item.setPrice(Integer.parseInt(request.getParameter("price")));
		item.setShop(ShopDAOImpl.getInstance().get(Integer.parseInt(request.getParameter("shopid"))));
		String imageUrl = request.getParameter("imageUrl");
		if (!imageUrl.equalsIgnoreCase(""))
			item.setImageUrl(imageUrl);
		if (ItemDAOImpl.getInstance().insertItem(item))
			return "item_added_success";
		return "item_added_fail";
	}

}
