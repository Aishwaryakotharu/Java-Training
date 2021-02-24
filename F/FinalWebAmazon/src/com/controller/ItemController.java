package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ItemDAOImpl;


@PropertySource(value= {"classpath:application.properties"})
@Controller
public class ItemController {

	@Autowired
	Environment environment;
	
	@Autowired
	ItemDAOImpl itemdao;

	public ItemDAOImpl getItemdao() {
		return itemdao;
	}

	public void setItemdao(ItemDAOImpl itemdao) {
		this.itemdao = itemdao;
	}
	@RequestMapping(value="/itementry", method = RequestMethod.POST)
	public ModelAndView itemEntry(HttpServletRequest request, HttpServletResponse response) {
		String itemname = request.getParameter("itemname");
		ModelAndView mandv=new ModelAndView();
		HttpSession session=request.getSession();
		if(itemdao.findByName(itemname) != null) {
			
			session.setAttribute("itemname", itemname);
			mandv.setViewName("itemname");
			
		}
		if(itemdao.findByName(itemname) == null) {
			session.setAttribute("itemname", itemname);
			mandv.setViewName("tryagain");
			
		}
		return mandv;
	}
}
