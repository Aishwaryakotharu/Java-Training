<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items</title>
<link rel="stylesheet" href="style.css" media="all" />
</head>
<body>
	<sql:query var="items" dataSource="${db }" > select * from items where shopid=<c:out value="${shopid}" /> </sql:query>
	<div class="container-center full-page">
		<form action="NextShop.do" method="get"class="flex direction-column">		
			<input type="hidden" name="route" value="nextshop" />
			<c:forEach items="${items.rows }" var="item" >
				<div class="flex">				
					<div class="img-container"><img src="<c:out value=${item.imageurl } />" class="img" /></div>
					<span class="mar-l-1"> <c:out value="${item.name}" /> </span>
					<input type="number" name="${item.name }" id="${item.name }" min="0" value="0" class="mar-l-1" />
					<c:out value="${item.unit }" />
				</div>
			</c:forEach>
				<input type="submit" value="next shop"  class="btn bg-color-blue text-white" />
		</form>
		<form action="Invoice.do" method="get">
			<button class="btn bg-color-blue text-white" type="submit"> Generate invoice </button>
		</form>
		<c:if test="${user.role.equalsIgnoreCase('seller') }">
		<a href="additem.jsp" class="btn bg-color-blue text-white"> Add Item </a>
	</c:if>
	</div>
</body>
</html>