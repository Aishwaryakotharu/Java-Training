<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" media="all" />
</head>
<body>
	<div class="container-center full-page">
		<form action="AddShop.do" method="get" class="flex direction-column">
			<input type="hidden" name="route" value="addshop" />
			<label for="name" class="mar-1">
				Shop Name : 
				<input type="text" required name="name" id="name" class="inp mar-l-1" />
			</label>
			<input type="submit" value="add" />
		</form>
	</div>
</body>
</html>
