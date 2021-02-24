package com.service;

import com.model.UserDTO;

public interface UserService {
	public  UserDTO findByPrimaryKey(Integer uid);
	public  UserDTO findByName(String uname);
	public  boolean insertUser(UserDTO userDto);
	public  boolean updateUser(UserDTO userDto);
	public  boolean deleteUser(UserDTO userDto);
}
