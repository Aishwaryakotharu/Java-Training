package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InvoiceDAOImpl;
import com.model.Invoice;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	InvoiceDAOImpl invoiceDAOImpl;
	
	public InvoiceDAOImpl getInvoiceDAOImpl() {
		return invoiceDAOImpl;
	}

	public void setInvoiceDAOImpl(InvoiceDAOImpl invoiceDAOImpl) {
		this.invoiceDAOImpl = invoiceDAOImpl;
	}

	@Override
	public Invoice findByPrimaryKey(int id) {
		Invoice res=invoiceDAOImpl.findByPrimaryKey(id);
		return res;
	}

	@Override
	public Invoice findByBillItem(int itemid, int billid) {
		Invoice res=invoiceDAOImpl.findByBillItem(itemid, billid);
		return res;
	}

	@Override
	public Boolean insertInvoice(Invoice invoiceDto) {
		Boolean res=invoiceDAOImpl.insertInvoice(invoiceDto);
		return res;
	}

	@Override
	public Boolean deleteInvoice(Invoice invoiceDto) {
		Boolean res=invoiceDAOImpl.deleteInvoice(invoiceDto);
		return res;
	}

}
