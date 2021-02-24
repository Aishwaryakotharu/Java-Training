package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.InvoiceMaster;
//import com.utility.HibernateUtility;
import com.dao.InvoiceMasterDAO;
import com.dao.InvoiceMasterDAOImpl;

@Service
@Transactional
public class InvoiceMasterServiceImpl implements InvoiceMasterService {

	@Autowired
	InvoiceMasterDAO invoiceMasterDAO;
	
	public InvoiceMasterDAO getInvoiceMasterDAO() {
		return invoiceMasterDAO;
	}

	public void setInvoiceMasterDAO(InvoiceMasterDAO invoiceMasterDAO) {
		this.invoiceMasterDAO = invoiceMasterDAO;
	}
	
	
	private InvoiceMasterServiceImpl() {
	}
	private static InvoiceMasterDAOImpl instance;
	public static InvoiceMasterDAOImpl getInstance() {
		if (instance == null)
			instance = new InvoiceMasterDAOImpl();
		return instance;
	}
	
	
	@Override
	public InvoiceMaster get(int id) {
		InvoiceMaster res=invoiceMasterDAO.get(id);
		return res;
	}

	@Override
	public Boolean insertBill(InvoiceMaster invoiceMaster) {
		Boolean res=invoiceMasterDAO.insertBill(invoiceMaster);
		return res;
		
	}

	@Override
	public Boolean deleteBill(InvoiceMaster invoiceMaster) {
		Boolean res=invoiceMasterDAO.deleteBill(invoiceMaster);
		return res;
	}

}
