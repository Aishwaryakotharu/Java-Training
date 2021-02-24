package daoImp;
//import java.sql.Connection;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;


//import utility.ConnectionUtility;
import utility.HibernateUtility;
//import project.UserDAOImpl;
public class InvoiceMasterDAOImpl extends InvoiceMasterDAO {
	//HibernateUtility
	private static InvoiceMasterDAOImpl instance;

	private InvoiceMasterDAOImpl() {
	}

	public static InvoiceMasterDAOImpl getInstance() {
		if (instance == null)
			instance = new InvoiceMasterDAOImpl();
		return instance;
	}
	@SuppressWarnings("null")
	@Override
	public InvoiceMaster get(int id) {
		InvoiceMaster invoiceMaster = null;
//		Connection con = ConnectionUtility.createConnection();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from bills where id=?;");
//			statement.setInt(1, id);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				invoiceMaster.setId(rs.getInt(1));
//				invoiceMaster.setDate(rs.getDate(2));
//				invoiceMaster.setUser(UserDAOImpl.getInstance().findByPrimaryKey(rs.getInt(3)));
//				invoiceMaster.setDiscount(rs.getInt(4));
//				invoiceMaster.setGst(rs.getInt(5));
//			}
//			statement.close();
//			ConnectionUtility.closeConnection(null);
//		}catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//			e.printStackTrace();
//		}
//		return invoiceMaster;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(invoiceMaster.getClass());
			criteria.add(Restrictions.idEq(id));
			invoiceMaster = (InvoiceMaster) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return invoiceMaster;
	}

	
	
	@Override
	public Boolean insertBill(InvoiceMaster invoiceMaster) {
		int rows_updated=0;
//		Connection con = ConnectionUtility.createConnection();
//		try {
//			PreparedStatement statement = con.prepareStatement("insert into bills (id,date,cid,discount,gst) values (?,?,?,?);");
//			statement.setDate(2,invoiceMaster.getDate());
//			statement.setInt(3, invoiceMaster.getId());
//			statement.setInt(4, invoiceMaster.getDiscount());
//			statement.setInt(5, invoiceMaster.getGst());
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
		try {
			Session session = 			HibernateUtility.getSession();
			String hql = "insert into bills (date,user_id,discount,gst) values (:Date,:UserId,:Discount,:Gst);";
			Query q = session.createQuery(hql);
			q.setParameter("Date", invoiceMaster.getDate());
			q.setParameter("UserId", invoiceMaster.getUser().getid());
			q.setParameter("Discount", invoiceMaster.getDiscount());
			q.setParameter("Gst", invoiceMaster.getGst());
			rows_updated = q.executeUpdate();
			Criteria criteria = session.createCriteria(invoiceMaster.getClass());
			criteria.setProjection(Projections.max("id"));
			invoiceMaster.setId((Integer) criteria.uniqueResult());
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
		
	}

	@Override
	public Boolean deleteBill(InvoiceMaster invoiceMaster) {
		int rows_updated=0;
//		Connection con = ConnectionUtility.createConnection();
//		PreparedStatement statement;
//		try {
//			statement = con.prepareStatement("delete from bills where id = ? ");
//			statement.setInt(1, invoiceMaster.getId());
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
		try {
			Session session = HibernateUtility.getSession();
			String hql = "delete from bills where id = :id ";
			Query q = session.createQuery(hql);
			q.setParameter("id", invoiceMaster.getId());
			rows_updated = q.executeUpdate();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated!= 0;
	}

}
