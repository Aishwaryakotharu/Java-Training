package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.UserDTO;
import project.UserLoginBusiness;
import project.UserLoginBusinessImpl;

public class LogoutAction extends Action{

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("name");
		@SuppressWarnings("unused")
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		UserLoginBusiness userlogic = UserLoginBusinessImpl.getInstance();
		UserDTO user=new UserDTO();
		System.out.println("Status before : "+user.getLoginStatus());
		user.setLoginStatus(false);
		boolean res=userlogic.updateStatus(username, 0);
		System.out.println("Employee logout set status result : "+res);
		System.out.println("Status after :"+user.getLoginStatus());
		session.invalidate();
		if(res)
		return "login.success";
		else
			return "login.failure";
	}

}
