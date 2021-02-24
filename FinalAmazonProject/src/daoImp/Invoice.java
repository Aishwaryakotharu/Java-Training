package daoImp;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "Invoice")
@Table(name = "invoices")
public class Invoice implements Serializable, Comparable<Invoice>  {

	@Id() 
	private int id,quantity;
	private Item item;
	private InvoiceMaster invoice_master;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InvoiceMaster getBill() {
		return invoice_master;
	}

	public void setBill(InvoiceMaster invoice_master) {
		this.invoice_master = invoice_master;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Invoice() {
	}

	public Invoice(InvoiceMaster invoice_master, Item item, int quantity) {
		this.invoice_master = invoice_master;
		this.item = item;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Invoice o) {
		return this.invoice_master.compareTo(o.getBill()) == 0 && this.item.compareTo(o.getItem()) == 0 ? 0 : 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + quantity;
		result = prime * result + ((invoice_master == null) ? 0 : invoice_master.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (id != other.id)
			return false;
		if (quantity != other.quantity)
			return false;
		if (invoice_master == null) {
			if (other.invoice_master != null)
				return false;
		} else if (!invoice_master.equals(other.invoice_master))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
