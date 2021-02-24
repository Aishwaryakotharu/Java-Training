<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" media="all" />
</head>
<body>
	<sql:query var="shops" dataSource="${db}" > select * from shops; </sql:query>
	<div class="container-center flex direction-column align-center full-page" >
		<c:forEach items="${shops.rows }" var="shop" >
			<a href="selectshop.jsp?shopid=${shop.id}" class="btn mar-1 bg-color-blue text-white" > <c:out value="${shop.name}" /> </a>
		</c:forEach>
	<c:if test="${user.role.equalsIgnoreCase('seller') }">
		<a href="addshop.jsp" class="btn bg-color-blue text-white"> Add Shop </a>
	</c:if>
	</div>
</body>
</html>
