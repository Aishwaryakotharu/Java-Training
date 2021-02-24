package control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.Action;

public class RequestProcessor implements Cloneable{
	
	synchronized void process(HttpServletRequest request,HttpServletResponse response) {
		try {
			ServletContext ctx=request.getServletContext();
			
			Properties configFile = (Properties) ctx.getAttribute("configFile");
			
			String formid=request.getParameter("formid");
			
			String actionClass=configFile.getProperty(formid);
			
			@SuppressWarnings("unused")
			HttpSession session = request.getSession();
			
			Action action=(Action)Class.forName(actionClass).getDeclaredConstructor().newInstance();
			String result=action.execute(request, response);
			String nextPage=configFile.getProperty(result);
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public RequestProcessor getClone() {
		try {
			return (RequestProcessor)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}