<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Select Shop</title>
</head>
<body>
	<c:set var="shopid" value="${param.shopid}" scope="session" />
	<jsp:forward page="items.jsp" />
</body>
</html>