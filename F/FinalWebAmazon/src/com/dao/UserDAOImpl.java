package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.UserDTO;
//import java.sql.SQLException;
//import utility.ConnectionUtility;
import com.HibernateUtility;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

public class UserDAOImpl extends UserDAO{
	
	private static UserDAOImpl instance;
	
	public static UserDAOImpl getInstance() {
		if (instance == null)
			instance = new UserDAOImpl();
		return instance;
	}
	public UserDAOImpl() {
	};
	//fields
		Connection con=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;	
		UserDTO user;

	@Override
	public UserDTO findByPrimaryKey(Integer id) {
//		con=ConnectionUtility.createConnection();
//		
//		try {
//			statement=con.prepareStatement("select * from users where id=?");
//			statement.setInt(1, id);
//			ResultSet rs = statement.executeQuery();
//			user = new UserDTO();
//			while (rs.next()) {
//				user.setid(rs.getInt(1));
//				user.setname(rs.getString(2));
//				user.setpass(rs.getString(3));
//				user.setAddress(rs.getString(4));
//				user.setRole(rs.getString(5));
//				user.setLoginStatus(rs.getInt(6) == 1);
//			}
//			statement.close();
//		} 
//		
//		catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return user;
		UserDTO user = new UserDTO();
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(user.getClass());
			criteria.add(Restrictions.idEq(id));
			user = (UserDTO) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return user;
	}
	
	
	@Override
	public UserDTO findByName(String name) {
//		try {
//			statement=con.prepareStatement("select * from users where name=?;");
//			statement.setString(1, name);
//			ResultSet rs = statement.executeQuery();
//			user = new UserDTO();
//			while (rs.next()) {
//				user.setid(rs.getInt(1));
//				user.setname(rs.getString(2));
//				user.setpass(rs.getString(3));
//				user.setAddress(rs.getString(4));
//				user.setRole(rs.getString(5));
//				user.setLoginStatus(rs.getInt(6) == 1);
//			}
//			statement.close();
//		} 
//		
//		catch (Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return user;
		UserDTO user = new UserDTO();
		try {
			Session session = HibernateUtility.getSession();
			Criteria criteria = session.createCriteria(user.getClass());
			criteria.add(Property.forName("name").eq(name));
			user = (UserDTO) criteria.uniqueResult();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return user;
		
	}
	
	
	@Override
	public boolean insertUser(UserDTO userDto) {
		int rows_updated=0;
//		try {
//			statement=con.prepareStatement("INSERT INTO users (uname,upass,ustatus) VALUES(?,?,?)");
//			con.prepareStatement("update users set status=? where id=?");
//			statement.setString(1, userDto.getname());
//			statement.setString(2,userDto.getpass());
//			statement.setString(3, userDto.getAddress());
//			statement.setString(3, userDto.getRole());
//			
//			rows_updated = statement.executeUpdate();
//			
//			statement.close();
//			con.commit();
//		} catch (SQLException e) {
//			try {
//				con.rollback();
//			} catch (SQLException e1)
//			{
//				e1.printStackTrace();
//			}
//			ConnectionUtility.closeConnection(e);
//			e.printStackTrace();
//		}
//		return rows_updated==0?false:true;
		try {
			Session session = HibernateUtility.getSession();
			String hql = "insert into users (name,password,address,role,login_status) values ( :Name,:Password,:Address,:Role,:LoginStatus ) ";
			Query q = session.createQuery(hql);
			q.setParameter("Name", userDto.getname());
			q.setParameter("Password", userDto.getpass());
			q.setParameter("Address", userDto.getAddress());
			q.setParameter("Role", userDto.getRole());
			q.setParameter("LoginStatus", userDto.getLoginStatus());
			rows_updated = q.executeUpdate();
			Criteria criteria = session.createCriteria(userDto.getClass());
			criteria.setProjection(Projections.max("id"));
			userDto.setid((Integer) criteria.uniqueResult());
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated != 0;
	}
	
	
	
	@Override
	public boolean updateUser(UserDTO userDto) {
		int rows_updated=0;
//		try {
//			statement=con.prepareStatement("IUPDATE users set uname=?, upass=?, status=?  where id=?");
//			
//			statement.setString(1, userDto.getname());
//			statement.setString(2, userDto.getpass());
//			statement.setString(3, userDto.getAddress());
//			statement.setString(4, userDto.getRole());
//			statement.setInt(5, userDto.getLoginStatus()?0:1);
//			statement.setInt(5, userDto.getid());
//			rows_updated = statement.executeUpdate();
//			
//			statement.close();
//			con.commit();
//		}catch (SQLException e) {
//			try {
//				con.rollback();
//			} catch (SQLException e1)
//			{
//				e1.printStackTrace();
//			}
//			ConnectionUtility.closeConnection(e);
//			e.printStackTrace();
//		}
//		return rows_updated==0?false:true;
		try {
			Session session = HibernateUtility.getSession();
			String hql = "update users set name=:Name, password=:Password, address=:Address , role = :Role, login_status=:LoginStatus where id = :Id";
			Query q = session.createQuery(hql);
			q.setParameter("Name", userDto.getname());
			q.setParameter("Password", userDto.getpass());
			q.setParameter("Address", userDto.getAddress());
			q.setParameter("LoginStatus", userDto.getLoginStatus());
			q.setParameter("Role", userDto.getRole());
			q.setParameter("Id", userDto.getid());
			rows_updated = q.executeUpdate();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated == 0 ? false : true;
	}
	
	
	@Override
	public boolean deleteUser(UserDTO userDto) {
		int rows_updated=0;
//		try {
//			statement=con.prepareStatement("delete from users where id=?");
//			
//			statement.setInt(1,userDto.getid());
//			
//			rows_updated = statement.executeUpdate();
//			
//			statement.close();
//			con.commit();
//		} catch (SQLException e) {
//			try {
//				con.rollback();
//			} catch (SQLException e1)
//			{
//				e1.printStackTrace();
//			}
//			ConnectionUtility.closeConnection(e);
//			e.printStackTrace();
//		}
//		return rows_updated==0?false:true;
		try {
			Session session = HibernateUtility.getSession();
			String hql = "delete from users where id = :id ";
			Query q = session.createQuery(hql);
			q.setParameter("id", userDto.getid());
			rows_updated = q.executeUpdate();
			HibernateUtility.closeSession(null);
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		return rows_updated == 0 ? false : true;
	}
	
	
}

