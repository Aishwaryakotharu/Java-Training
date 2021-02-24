package com.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserDTO;
import com.dao.UserLoginBusiness;
import com.dao.UserLoginBusinessImpl;
public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		UserLoginBusiness userlogic = UserLoginBusinessImpl.getInstance();
		UserDTO user=new UserDTO();
		
		if(username.length()==0 || password==null)
		{
			System.out.println("login failed ,login  again");
			return "login.failure";
		}
		if(password.length()==0 || password==null) {
			System.out.println("login failed ,login  again");
			return "login.failure";
		}
		
		if(!userlogic.checkUser(username, password))
		return "login.failure";
		if(userlogic.checkUser(username, password))
			return "login.success";
		if (user.getLoginStatus())
			return "login.alreadyLoggedIn";
		if (!userlogic.updateStatus(username, user.getid()))
			return "login.failure";
		
			user.setLoginStatus(true);
			request.getSession().setAttribute("user", user);
			return "login.success";
			
	}

}
