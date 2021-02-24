<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome...Now Make the payment  Mr/Ms..:<%=session.getAttribute("uname") %></h3>
	<%
		Enumeration<String> en=session.getAttributeNames();
		while(en.hasMoreElements()){
			String name=en.nextElement();
			String value=(String)session.getAttribute(name);
			if(!name.equals("formid")&&!name.equals("shopid")&&!name.equals("uname")){
				out.println("<h1>"+name+":"+value+"</h1>");
			}
		}
		
	%>
</body>
</html>