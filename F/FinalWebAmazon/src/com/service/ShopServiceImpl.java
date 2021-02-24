package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ShopDAOImpl;
import com.model.Shop;
import com.HibernateUtility;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{

	@Autowired
	ShopDAOImpl shopDAOImpl;
	
	public ShopDAOImpl getShopDAOImpl() {
		return shopDAOImpl;
	}
	public void setShopDAOImpl(ShopDAOImpl shopDAOImpl) {
		this.shopDAOImpl = shopDAOImpl;
	}

	private static ShopServiceImpl shopdao_instance;
	public ShopServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public static ShopServiceImpl getInstance() {
		if ( shopdao_instance == null)
			 shopdao_instance = new ShopServiceImpl();
		return shopdao_instance;
	}
	@Override
	public Shop get(int id) {
		//Connection con = ConnectionUtility.createConnection();
				Shop shop = new Shop();
//				try {
//					PreparedStatement statement = con.prepareStatement("select * from shops where id=?;");
//					statement.setInt(1, id);
//					ResultSet rs = statement.executeQuery();
//					while (rs.next()) {
//						shop.setId(rs.getInt(1));
//						shop.setName(rs.getString(2));
//					}
//					statement.close();
//				} catch (Exception e) {
//					ConnectionUtility.closeConnection(e);
//				}
//				return shop;
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

	@Override
	public List<Shop> getAllShops() {
		List<Shop> res=shopDAOImpl.getAllShops();
		return res;
	}

	@Override
	public Shop findByName(String name) {
		Shop res=shopDAOImpl.findByName(name);
		return res;
	}

	@Override
	public Boolean insertShop(Shop shopDto) {
		boolean res=shopDAOImpl.insertShop(shopDto);
		return res;
	}

	@Override
	public Boolean deleteShop(Shop shopDto) {
		boolean res=shopDAOImpl.deleteShop(shopDto);
		return res;
	}

	@Override
	public int countShops() {
		int res=shopDAOImpl.countShops();
		return res;
	}

	@Override
	public Shop nextShop(int id) {
		Shop res=shopDAOImpl.nextShop(id);
		return res;
	}

}
