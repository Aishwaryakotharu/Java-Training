package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImp.Shop;
import daoImp.ShopDAOImpl;

public class ShopAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Shop shop = new Shop();
		shop.setName(request.getParameter("name"));
		if (ShopDAOImpl.getInstance().insertShop(shop))
			return "shop_adding_success";
		return "shop_adding_fail";
	}

}
