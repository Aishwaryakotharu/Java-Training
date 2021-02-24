package control;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
	    
	      
	public void sessionCreated(HttpSessionEvent sessionEvent) 
	{

        // Get the session that was created
		// Store something in the session, and log a message
        HttpSession session = sessionEvent.getSession();
        try 
        {
        	String msg="session created";
            System.out.println("[MySessionListener] Session created: "+session);
            session.setAttribute("msg", msg);
        } catch (Exception e)
        {
            System.out.println("[MySessionListener] Error setting session attribute: " + e.getMessage());
        }
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {

        // Get the session that was invalidated
        HttpSession session = sessionEvent.getSession();
        // Log a message
        @SuppressWarnings("unused")
		String msg="session destroyed";
        System.out.println("[MySessionListener] Session invalidated: "+session);
        System.out.println("[MySessionListener] Value of foo is: " + session.getAttribute("msg"));
    }
}
