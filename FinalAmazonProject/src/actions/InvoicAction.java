package actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImp.Invoice;
import daoImp.InvoiceDAOImpl;
import daoImp.InvoiceMaster;
import daoImp.InvoiceMasterDAOImpl;
import daoImp.Item;
import project.UserDTO;

public class InvoicAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		InvoiceMaster invoice_master= new InvoiceMaster();
		UserDTO user = (UserDTO) request.getAttribute("user");
		invoice_master.setUser(user);
		if (!InvoiceMasterDAOImpl.getInstance().insertBill(invoice_master))
			return "inoivce_gen_fail";
		request.getSession().setAttribute("bill", invoice_master);
		@SuppressWarnings("unchecked")
		HashMap<Item, Integer> selectedItems = (HashMap<Item, Integer>) request.getSession().getAttribute("selectedItems");
		for (Map.Entry<Item, Integer> sItem : selectedItems.entrySet()) {
			Invoice invoice = new Invoice(invoice_master, sItem.getKey(), sItem.getValue());
			if (!InvoiceDAOImpl.getInstance().insertInvoice(invoice))
				return "inoivce_gen_fail";
		}
		return "invoice_gen_success";
	}

}
