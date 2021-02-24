package com.service;

import com.model.InvoiceMaster;

public interface InvoiceMasterService {
	public  InvoiceMaster get(int id);

	public  Boolean insertBill(InvoiceMaster billDto);

	public Boolean deleteBill(InvoiceMaster billDto);
}
