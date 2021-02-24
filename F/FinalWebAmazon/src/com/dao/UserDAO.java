package com.dao;

import com.model.UserDTO;

//abstract methods 

public abstract class UserDAO{
	public abstract UserDTO findByPrimaryKey(Integer uid);
	public abstract UserDTO findByName(String uname);
	
	public abstract boolean insertUser(UserDTO userDto);
	public abstract boolean updateUser(UserDTO userDto);
	public abstract boolean deleteUser(UserDTO userDto);
}
