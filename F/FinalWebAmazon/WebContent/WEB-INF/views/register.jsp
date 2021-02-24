<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register page</title>
<link rel="stylesheet" href="style.css" media="all" />
</head>
<body>
	<div class="container-center full-page">
		<form action="Register.do" method="get" class="flex direction-column" >
			<input type="hidden" name="route" value="register" />
			<label for="name" class="mar-1">
				username : <input type="text" name="name" id="name" placeholder="Enter user name" required autofocus class="inp mar-l-1" />
			</label>
			<label for="password" class="mar-1" >
				password : <input type="password" name="password" id="password" placeholder="Enter your password" required class="inp mar-l-1" />
			</label>
			<label for="address" class="mar-1" >
				address : <input type="text" name="address" id="address" placeholder="Enter your address" class="inp mar-l-1" value="" />
			</label>
			<label for="role" class="mar-1">
				<input type="checkbox" name="role" id="role" value="seller" class="inp mar-r-1" /> click here if you are a seller
			</label>
			<input type="submit" value="submit" class="btn text-white bg-color-blue" />
		</form>
	</div>
</body>
</html>
