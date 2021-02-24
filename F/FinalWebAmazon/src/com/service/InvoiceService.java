package com.service;


import com.model.Invoice;


public interface InvoiceService {
	
	public Invoice findByPrimaryKey(int id);

	public Invoice findByBillItem(int itemid, int billid);

	public Boolean insertInvoice(Invoice invoiceDto);

	public Boolean deleteInvoice(Invoice invoiceDto);
}
