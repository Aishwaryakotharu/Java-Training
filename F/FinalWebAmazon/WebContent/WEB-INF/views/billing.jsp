<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invoice</title>
<link rel="stylesheet" href="style.css" media="all" />
</head>
<body>
	<h1 class="text-blue" >  billid : <c:out value="${bill.getId() }" /> </h1>
	<div class="container-center full-page">
		<table style="width:100%" >
			<tr>
				<th> name </th>
				<th> quantity </th>
				<th>  price </th>
			</tr>				
			<c:forEach items="${selectedItems.entrySet() }" var="item" >
				<tr>
					<td> <c:out value="${item.getKey().getName() }"></c:out> </td>
					<td> <c:out value="${item.getValue() }" /> </td>
					<td> <c:out value="${item.getKey().getPrice() }" /> </td>
				</tr>
			</c:forEach>		
			<tr>
				<td></td>
				<td></td>
				<td> <c:out value="${totalPrice }" /> </td>
			</tr>
		</table>
	</div>
	<form action="pdf.do" method="get">
		<input type="hidden" name="route" value="pdf-invoice" />
		<input type="submit" value="get as pdf" class="btn bg-color-blue mar-1 text-white" />
	</form>
	<form action="xl.do" method="get">
		<input type="hidden" name="route" value="xl-invoice" />
		<input type="submit" value="get as xl" class="btn bg-color-blue mar-1 text-white" />
	</form>
</body>
</html>ml>