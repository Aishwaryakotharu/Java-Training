<%@page language="java"  isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is error page.....</h1>
	<%=exception.getMessage() %>
</body>
</html>