package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.tomcat.jni.User;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserLoginBusinessImpl;
import com.model.UserDTO;
import com.dao.UserDAO;
@PropertySource(value= {"classpath:application.properties"})
@Controller
public class UserController {
	@Autowired
	Environment environment;
	
	@Autowired
	UserLoginBusinessImpl UserLoginBusinessImpl;

	public UserLoginBusinessImpl getUserLoginBusinessImpl() {
		return UserLoginBusinessImpl;
	}

	public void setUserLoginBusinessImpl(UserLoginBusinessImpl UserLoginBusinessImpl) {
		this.UserLoginBusinessImpl = UserLoginBusinessImpl;
	}
	UserDAO user1;
	
	@RequestMapping(value="/userentry", method = RequestMethod.POST)
	public ModelAndView userEntry(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		UserDTO user=new UserDTO();
		
	ModelAndView mandv=new ModelAndView();
	HttpSession session=request.getSession();
	if(UserLoginBusinessImpl.checkUser(name, password))
	{
		user=user1.findByName(name);
		session.setAttribute("username", user);
		mandv.setViewName("welcome");
	}
	if(!UserLoginBusinessImpl.checkUser(name, password))
		mandv.setViewName("login");
	return mandv;
	}
	
	@RequestMapping(value="/useregister", method = RequestMethod.POST)
	public ModelAndView handleuserEntry(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		ModelAndView mandv=new ModelAndView();
		@SuppressWarnings("unused")
		UserDTO user=new UserDTO();
		
		String uname = request.getParameter("name");
		String upassword = request.getParameter("password");
		
			session.setAttribute("username", uname);
			session.setAttribute("password", upassword);
			mandv.setViewName("register");
	return mandv;
		
	}
}
