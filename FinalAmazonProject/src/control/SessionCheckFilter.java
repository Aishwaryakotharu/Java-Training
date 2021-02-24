package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpSession session=hrequest.getSession();
		
		
		if (session.isNew()) {
		    // Just created.
			System.out.println("session is new");
			String Page = "/sessiontimeout.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(Page);
            dispatcher.forward(request, response);
		} else {
		    // Already created.
			System.out.println("session already exists");
			chain.doFilter(request, response);
		}
		 
		
	}
	public void destroy() {
    }
 
    public void init(FilterConfig fConfig) throws ServletException {
    }
	 
}