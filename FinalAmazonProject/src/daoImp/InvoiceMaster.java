package daoImp;

import javax.persistence.Entity;

import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import project.UserDTO;

@SuppressWarnings("serial")
@Entity(name="invoicemaster")
@Table(name="invoice_master")
public class InvoiceMaster implements Serializable, Comparable<InvoiceMaster> {
	
	private UserDTO user;
	private int id;
	private Date date = Date.valueOf(LocalDate.now());
	private int discount, gst;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getGst() {
		return gst;
	}

	public void setGst(int gst) {
		this.gst = gst;
	}

	@Override
	public String toString() {
		return "id = " + id + " date = " + date + " user = " + user + " discount = " + discount + " gst = " + gst;
	}
	public int compareTo(InvoiceMaster o) {
		return this.id == o.getId() ? 0 : 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + discount;
		result = prime * result + gst;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		InvoiceMaster other = (InvoiceMaster) obj;
		if (id != other.id)
			return false;
		if (discount != other.discount)
			return false;
		if (gst != other.gst)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
