<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Fail</title>
</head>
<body>
	<h1 class="text-red">
	<c:out value="${params.thing }" /> has not been added
	</h1>
	<a href="<c:out value='${params.thing}' />s.jsp" class="btn bg-color-blue text-white"> go back to see <c:out value="${params.thing}" />s </a>
</body>
</html>