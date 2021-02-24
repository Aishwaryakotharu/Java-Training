package com.service;

import com.model.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDAOImpl;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAOImpl UserDAOImpl;
	
	public UserDAOImpl getUserDAOImpl() {
		return UserDAOImpl;
	}

	public void setUserDAOImpl(UserDAOImpl userDAOImpl) {
		UserDAOImpl = userDAOImpl;
	}

	@Override
	public UserDTO findByPrimaryKey(Integer uid) {
		UserDTO res=UserDAOImpl.findByPrimaryKey(uid);
		return res;
	}

	@Override
	public UserDTO findByName(String uname) {
		UserDTO res=UserDAOImpl.findByName(uname);
		
		return res;
	}

	@Override
	public boolean insertUser(UserDTO userDto) {
		boolean res=UserDAOImpl.insertUser(userDto);
		return res;
	}

	@Override
	public boolean updateUser(UserDTO userDto) {
		boolean res=UserDAOImpl.updateUser(userDto);
		return res;
	}
	

	@Override
	public boolean deleteUser(UserDTO userDto) {
		boolean res=UserDAOImpl.deleteUser(userDto);
		return res;
	}

}
