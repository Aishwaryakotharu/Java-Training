package utility;

import java.util.List;

import daoImp.Invoice;
import daoImp.InvoiceMaster;
import project.UserDAOImpl;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="user")
@Table(name="user")
public class Bill {
	private InvoiceMaster invoiceMaster;
	private List<Invoice> invoices;
	private UserDAOImpl user;
	public InvoiceMaster getInvoiceMaster() {
		return invoiceMaster;
	}
	public void setInvoiceMaster(InvoiceMaster invoiceMaster) {
		this.invoiceMaster = invoiceMaster;
	}
	
	public List<Invoice> getInvoices() {
		return invoices;
	}
	public UserDAOImpl getUser() {
		return user;
	}
	public void setUser(UserDAOImpl user) {
		this.user = user;
	}
	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
}
