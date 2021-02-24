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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

public class ItemDAOImpl extends ItemDAO {

	//HibernateUtility
	private static ItemDAOImpl itemdao_instance;

	public static ItemDAOImpl getInstance() {
		if (itemdao_instance == null)
			itemdao_instance = new ItemDAOImpl();
		return itemdao_instance;
	}
	
	private ItemDAOImpl() {
	}

	@Override
	public Item findByName(String name) {
		//Connection con = ConnectionUtility.createConnection();
		Item item = new Item();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from items where name=?;");
//			statement.setString(1, name);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				item.setId(rs.getInt(1));
//				item.setName(rs.getString(2));
//				item.setUnit(rs.getString(3));
//				item.setPrice(rs.getInt(4));
//				item.setImageUrl(rs.getString(5));
//				item.setShop(ShopDAOImpl.getInstance().get(rs.getInt(6)));
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return item;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(item.getClass());
			criteria.add(Property.forName("name").eq(name));
			item = (Item) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return item;
	}

	@Override
	public Item getitem(int id) {
		//Connection con = ConnectionUtility.createConnection();
		Item item = new Item();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from items where id=?;");
//			statement.setInt(1, id);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				item.setId(rs.getInt(1));
//				item.setName(rs.getString(2));
//				item.setUnit(rs.getString(3));
//				item.setPrice(rs.getInt(4));
//				item.setImageUrl(rs.getString(5));
//				item.setShop(ShopDAOImpl.getInstance().get(rs.getInt(6)));
//			}
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return item;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(item.getClass());
			criteria.add(Restrictions.idEq(id));
			item = (Item) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItems(Shop shop) {
		//Connection con = ConnectionUtility.createConnection();
		List<Item> items = new ArrayList<>();
//		try {
//			PreparedStatement statement = con.prepareStatement("select * from items where shopid=?");
//			statement.setInt(1, shop.getId());
//			ResultSet rs = statement.executeQuery();
//			while (rs.next())
//				item.add(new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
//						shop));
//			statement.close();
//		} catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return item;
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(shop.getClass());
			criteria.add(Restrictions.eq("shop_id", shop.getId()));
			items = criteria.list();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return items;
	}

	
	@Override
	public Boolean insertItem(Item item) {
		int rows_updated = 0;
		//Connection con = ConnectionUtility.createConnection();
		
//		try {
//			PreparedStatement statement = con
//					.prepareStatement("insert into items (name,unit,price, imageurl,shopid) values (?,?,?,?,?);");
//			statement.setString(1, item.getName());
//			statement.setString(2, item.getUnit());
//			statement.setInt(3, item.getPrice());
//			statement.setString(4, item.getImageUrl());
//			statement.setInt(5, item.getShop().getId());
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
			String hql = "insert into items (name,unit,price, image_url,shop_id) values (:Name,:Unit,:Price,:ImageUrl,:ShopId);";
			Query q = session.createQuery(hql);
			q.setParameter("Name", item.getName());
			q.setParameter("Unit", item.getUnit());
			q.setParameter("Price", item.getPrice());
			q.setParameter("ShopId", item.getShop().getId());
			q.setParameter("ImageUrl", item.getImageUrl());
			rows_updated = q.executeUpdate();
			Criteria criteria = session.createCriteria(item.getClass());
			criteria.setProjection(Projections.max("id"));
			item.setId((Integer) criteria.uniqueResult());
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}

	@Override
	public Boolean updateItem(Item item) {
		int rows_updated = 0;
//		Connection con = ConnectionUtility.createConnection();
//		
//		try {
//			PreparedStatement statement = con
//					.prepareStatement("update items set name=?, shopid=?,price=?,imageurl=?, unit=?  where id = ?");
//			statement.setString(1, item.getName());
//			statement.setInt(2, item.getShop().getId());
//			statement.setInt(3, item.getPrice());
//			statement.setString(4, item.getImageUrl());
//			statement.setString(5, item.getUnit());
//			statement.setInt(6, item.getId());
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
			String hql = "update items set name=:Name, shop_id=:ShopId,price=:Price,imageurl=:ImageUrl, unit=:Unit  where id = :Id";
			Query q = session.createQuery(hql);
			q.setParameter("Name", item.getName());
			q.setParameter("Unit", item.getUnit());
			q.setParameter("Price", item.getPrice());
			q.setParameter("ImageUrl", item.getImageUrl());
			q.setParameter("ShopId", item.getShop().getId());
			q.setParameter("Id", item.getId());
			rows_updated = q.executeUpdate();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}

	@Override
	public Boolean deleteItem(Item item) {
		int rows_updated = 0;
//		Connection con = ConnectionUtility.createConnection();
//		
//		try {
//			PreparedStatement statement = con
//					.prepareStatement(" delete from items where id = ?");
//			statement.setInt(1, item.getId());
//			
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
		String hql = "delete from items where id = :id ";
		try {
			Session session = HibernateUtility.getSession();
			Query q = session.createQuery(hql);
			q.setParameter("id", item.getId());
			rows_updated = q.executeUpdate();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}
	
}
