package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserMethods {
	private String uName;
	private String uPass;
	private Connection conn;
	private PreparedStatement ps;
	private int id = -1;

	public UserMethods(String un, String up) {
		this.uName = un;
		this.uPass = up;
	}

	public boolean ifExist() throws Exception {
		ps = conn.prepareStatement("select * from users where uname=?");
		ps.setString(1, this.uName);
		return ps.executeQuery().next();
	}

	public boolean isLoggedIn() throws Exception {
		ps = conn.prepareStatement("select status from users where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) == 1)
				return true;
			else
				return false;
		}
		return false;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int updateStatus(int in) throws Exception {
		ps = conn.prepareStatement("update users set status=? where id=?");
		ps.setInt(1, in);
		ps.setInt(2, id);
		return ps.executeUpdate();
	}

	public int logout() throws Exception {
		return this.updateStatus(0);
	}

	public int createUser() throws Exception {
		ps = conn.prepareStatement("insert into users(uname,upass,status) values(?,?,1);");
		ps.setString(1, uName);
		ps.setString(2, uPass);
		return ps.executeUpdate();
	}

	public int insertId() throws Exception {
		ps = conn.prepareStatement("select id from users where uname=? AND upass=?");
		ps.setString(1, uName);
		ps.setString(2, uPass);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			this.id = rs.getInt(1);
		System.out.println(id);
		return this.id;
	}

	public void closeAll() throws Exception {
		ps.close();
		conn.close();
	}

}
