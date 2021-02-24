<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link rel="stylesheet" href="style.css" media="all" />
</head>
<body>
	<div class="container-center full-page">
		<form action="Login.do" method="get" class="flex direction-column" >
			<input type="hidden" name="route" value="login" />
			<label for="name" class="mar-1">
			username : 			
			<input type="text" name="name" id="name" placeholder="Enter your name" autofocus required class="inp mar-l-1" />
			</label>
			<label for="password" class="mar-1">
				password: 
				<input type="text" name="password" id="password" placeholder="Enter your password" required class="inp mar-l-1"  />
			</label>
			<input type="submit" value="submit" class="btn bg-color-blue text-white" />
		</form>
	</div>
</body>
</html>