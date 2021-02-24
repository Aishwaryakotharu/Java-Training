package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAOImpl;
import com.dao.UserLoginBusinessImpl;
import com.model.UserDTO;


public class InsertUserAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserLoginBusinessImpl userlogic = UserLoginBusinessImpl.getInstance();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		if (userlogic.checkUser(username, password))
			return "already_reg";
		UserDTO user = new UserDTO();
		user.setname(username);
		user.setpass(password);
		if (!UserDAOImpl.getInstance().insertUser(user))
			return "reg_fail";
		return "reg_success";
	}

}
