package com.dao;

import com.model.Invoice;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import utility.ConnectionUtility;
import com.HibernateUtility;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
public class InvoiceDAOImpl extends InvoiceDAO {
	//HibernateUtility
	private static InvoiceDAOImpl InvoiceDAOImpl_instance;
	private InvoiceDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static InvoiceDAOImpl getInstance() {
		if (InvoiceDAOImpl_instance == null)
			InvoiceDAOImpl_instance = new InvoiceDAOImpl();
		return InvoiceDAOImpl_instance;
	}
	
	
	@Override
	public Invoice findByPrimaryKey(int id) {
		//Connection con = ConnectionUtility.createConnection();
		Invoice invoice = new Invoice();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from invoices where id=?;");
//			statement.setInt(1, id);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				invoice.setId(rs.getInt(1));
//				invoice.setBill(InvoiceMasterDAOImpl.getInstance().get(rs.getInt(2)));
//				invoice.setItem(ItemDAOImpl.getInstance().getitem(rs.getInt(3)));
//				invoice.setQuantity(rs.getInt(4));
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return invoice;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(invoice.getClass());
			criteria.add(Restrictions.idEq(id));
			invoice = (Invoice) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return invoice;
	}

	@Override
	public Invoice findByBillItem(int itemid, int billid) {
		//Connection con = ConnectionUtility.createConnection();
		Invoice invoice = new Invoice();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from invoices where itemid=? and billid=?;");
//			statement.setInt(1, itemid);
//			statement.setInt(2, billid);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				invoice.setId(rs.getInt(1));
//				invoice.setBill(InvoiceMasterDAOImpl.getInstance().get(rs.getInt(2)));
//				invoice.setItem(ItemDAOImpl.getInstance().getitem(rs.getInt(3)));
//				invoice.setQuantity(rs.getInt(4));
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return invoice;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria("Invoice");
			Criterion checkItem = Restrictions.eq("item_id", itemid);
			Criterion checkBill = Restrictions.eq("bill_id", billid);
			criteria.add(Restrictions.and(checkItem, checkBill));
			invoice = (Invoice) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return invoice;
	}

	@Override
	public Boolean insertInvoice(Invoice invoice) {
		int rows_updated = 0;
//		Connection con = ConnectionUtility.createConnection();
//		try {
//			PreparedStatement statement = con
//					.prepareStatement("insert into invoices (billid,itemid,quantity) values (?,?,?);");
//			statement.setInt(2, invoice.getBill().getId());
//			statement.setInt(3, invoice.getItem().getId());
//			statement.setInt(4, invoice.getQuantity());
//			rows_updated = statement.executeUpdate();
//			statement.close();
//			con.commit();
//		} catch (Exception e) {
//			try {
//				con.rollback();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		return rows_updated == 0 ? false : true;
//	
		try {
			Session session = HibernateUtility.getSession();
			String hql = "insert into invoices (bill_id,item_id,quantity) values (:bill,:item,:quantity);";
			Query q = session.createQuery(hql);
			q.setParameter("bill", invoice.getBill().getId());
			q.setParameter("item", invoice.getItem().getId());
			q.setParameter("quantity", invoice.getQuantity());
			rows_updated = q.executeUpdate();
			Criteria criteria = session.createCriteria(invoice.getClass());
			criteria.setProjection(Projections.max("id"));
			invoice.setId((Integer) criteria.uniqueResult());
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}

	@Override
	public Boolean deleteInvoice(Invoice invoice) {
		int rows_updated = 0;
//		Connection con = ConnectionUtility.createConnection();
//		try {
//			PreparedStatement statement = con
//					.prepareStatement("delete from invoices where id = ?");
//			statement .setInt(1, invoice.getId());
//			 rows_updated = statement .executeUpdate();
//			 statement .close();
//			con.commit();
//		} catch (Exception e) {
//			try {
//				con.rollback();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		return rows_updated == 0 ? false : true;
		try {
			Session session = HibernateUtility.getSession();
			String hql = "delete from invoices where id = :id ";
			Query q = session.createQuery(hql);
			q.setParameter("id", invoice.getId());
			rows_updated = q.executeUpdate();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}

	

	

}
