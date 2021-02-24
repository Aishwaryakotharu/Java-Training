package daoImp;

public abstract class InvoiceMasterDAO {
	public abstract InvoiceMaster get(int id);

	public abstract Boolean insertBill(InvoiceMaster billDto);

	public abstract Boolean deleteBill(InvoiceMaster billDto);
}
