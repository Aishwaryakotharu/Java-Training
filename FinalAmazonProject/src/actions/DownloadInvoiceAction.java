package actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

import daoImp.Item;
import utility.PdfGen;

public class DownloadInvoiceAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		PdfGen pdf = new PdfGen("invoice.pdf");
		List<List<String>> data = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		temp.add("Name");
		temp.add("quantity");
		temp.add("price");
		data.add(temp);
		@SuppressWarnings("unchecked")
		HashMap<Item, Integer> selectedItems = (HashMap<Item, Integer>) request.getSession().getAttribute("selectedItems");
		for (Map.Entry<Item, Integer> sItem : selectedItems.entrySet()) {
			temp = new ArrayList<>();
			temp.add(sItem.getKey().getName());
			temp.add(Integer.toString(sItem.getValue()));
			temp.add(Integer.toString(sItem.getKey().getPrice()));
			data.add(temp);
		}
		temp = new ArrayList<>();
		temp.add("");
		temp.add("");
		int totalPrice = (int) request.getSession().getAttribute("totalPrice");
		temp.add(Integer.toString(totalPrice));
		data.add(temp);
		try {
			pdf.createTablePdf(data);
		} catch (DocumentException e) {
			e.printStackTrace();
			return "invoice_pdf_fail";
		}
		return "invoice_pdf_success";
	}

}

