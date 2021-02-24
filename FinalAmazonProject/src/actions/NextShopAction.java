package actions;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImp.Item;
import daoImp.ItemDAOImpl;
import daoImp.Shop;
import daoImp.ShopDAOImpl;

public class NextShopAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int currentShopId = (int) request.getSession().getAttribute("shopid");
		Shop nextShop = ShopDAOImpl.getInstance().nextShop(currentShopId);
		if (request.getSession().getAttribute("selectedItems") == null) {
			HashMap<Item, Integer> selectedItems = new HashMap<Item, Integer>();
			request.getSession().setAttribute("selectedItems", selectedItems);
		}
		if (request.getSession().getAttribute("totalPrice") == null) {
			int totalPrice = 0;
			request.getSession().setAttribute("totalPrice", totalPrice);
		}
		int totalPrice = (int) request.getSession().getAttribute("totalPrice");
		@SuppressWarnings("unchecked")
		HashMap<Item, Integer> selectedItems = (HashMap<Item, Integer>) request.getSession().getAttribute("selectedItems");
		List<Item> items = ItemDAOImpl.getInstance()
				.getAllItems(ShopDAOImpl.getInstance().get(currentShopId));
		String quantity;
		for (Item item : items) {
			quantity = request.getParameter(item.getName());
			if (quantity.compareTo("0") == 0)
				continue;
			totalPrice += item.getPrice() * Integer.parseInt(quantity);
			selectedItems.put(item, Integer.parseInt(quantity));
		}
		request.getSession().setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("selectedItems", selectedItems);
		if (nextShop.getId() == 0)
			return "end_of_shopping";
		if (nextShop.getName() == null)
			return "nextshop_fail";
		request.getSession().setAttribute("shopid", nextShop.getId());
		return "nextshop_success";
	}

}
