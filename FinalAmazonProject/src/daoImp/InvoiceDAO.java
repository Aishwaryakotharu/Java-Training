package daoImp;

public abstract class InvoiceDAO {
	public abstract Invoice findByPrimaryKey(int id);

	public abstract Invoice findByBillItem(int itemid, int billid);

	public abstract Boolean insertInvoice(Invoice invoiceDto);

	public abstract Boolean deleteInvoice(Invoice invoiceDto);
}
