package daoImp;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import utility.ConnectionUtility;
import utility.HibernateUtility;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
public  class ShopDAOImpl extends ShopDAO  {
	//HibernateUtility
	private static ShopDAOImpl shopdao_instance;

	private ShopDAOImpl() {
	}

	public static ShopDAOImpl getInstance() {
		if ( shopdao_instance == null)
			 shopdao_instance = new ShopDAOImpl();
		return shopdao_instance;
	}
	@Override
	public Shop get(int id) {
		//Connection con = ConnectionUtility.createConnection();
		Shop shop = new Shop();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from shops where id=?;");
//			statement.setInt(1, id);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				shop.setId(rs.getInt(1));
//				shop.setName(rs.getString(2));
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return shop;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(shop.getClass());
			criteria.add(Restrictions.idEq(id));
			shop = (Shop) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return shop;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShops() {
		//Connection con = ConnectionUtility.createConnection();
		List<Shop> shops = new ArrayList<>();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from shops");
//			ResultSet rs =statement.executeQuery();
//			while (rs.next())
//				shops.add(new Shop(rs.getInt(1), rs.getString(2)));
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return shops;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria("Shop");
			shops = criteria.list();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return shops;
	}

	@Override
	public Shop findByName(String name) {
		//Connection con = ConnectionUtility.createConnection();
		Shop shop = new Shop();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from shops where name=?;");
//			statement.setString(1, name);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				shop.setId(rs.getInt(1));
//				shop.setName(rs.getString(2));
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return shop;
		try {
			Session session =HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(shop.getClass());
			criteria.add(Property.forName("name").eq(name));
			shop = (Shop) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return shop;
	}

	@Override
	public Boolean insertShop(Shop shop) {
		int rows_updated=0;
//		Connection con = ConnectionUtility.createConnection();
//		
//		try {
//			PreparedStatement statement = con.prepareStatement("insert into shops (name) values (?);");
//			statement.setString(1, shop.getName());
//			rows_updated = statement .executeUpdate();
//			statement .close();
//			con.commit();
//		} catch (Exception e) {
//			try {
//				con.rollback();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		return  rows_updated== 0 ? false : true;
		try {
			Session session = HibernateUtility.getSession();
			String hql = "insert into shops (name) values (:name);";
			Query q = session.createQuery(hql);
			q.setParameter("name", shop.getName());
			q.executeUpdate();
			Criteria criteria = session.createCriteria(shop.getClass());
			criteria.setProjection(Projections.max("id"));
			shop.setId((Integer) criteria.uniqueResult());
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}

	@Override
	public Boolean deleteShop(Shop shop) {
		int rows_updated=0;
//		Connection con = ConnectionUtility.createConnection();
//		
//		try {
//			PreparedStatement statement = con.prepareStatement("delete from shops where id = ?");
//			statement.setString(1, shop.getName());
//			rows_updated = statement .executeUpdate();
//			statement .close();
//			con.commit();
//		} catch (Exception e) {
//			try {
//				con.rollback();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		return  rows_updated== 0 ? false : true;
		try {
			Session session = HibernateUtility.getSession();
			String hql = "delete from shops where id = :id";
			Query q = session.createQuery(hql);
			q.setParameter("id", shop.getId());
			q.executeUpdate();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}

	@Override
	public int countShops() {
		int count = 0;
		//Connection con = ConnectionUtility.createConnection();
		
//		try {
//			PreparedStatement statement = con.prepareStatement("select count(id) as total from shops");
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				count = rs.getInt(1);
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return count;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria("Shop");
			criteria.setProjection(Projections.count("id"));
			count = (Integer) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return count;
	}

	@Override
	public Shop nextShop(int id) {
		//Connection con = ConnectionUtility.createConnection();
		Shop shop = new Shop();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from shops where id= ( select min(id) from shops where id > ? )");
//			statement.setInt(1, id);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				shop = new Shop(rs.getInt(1), rs.getString(2));
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return shop;
		try {
			Session session = HibernateUtility.getSession();
			// String hql = "select * from shops where id= ( select min(id) from shops where
			// id > ? ) ";
			Criteria criteria = session.createCriteria("Shop");
			criteria.add(Restrictions.gt("id", id));
			criteria.addOrder(Order.asc("id"));
			shop = (Shop) criteria.list().get(0);
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return shop;
	}

}
