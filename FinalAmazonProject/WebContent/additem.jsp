<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item</title>
</head>
<body>
	<div class="container-center full-page">
		<form action="AddItem.do" method="get" class="flex direction-column">
			<input type="hidden" name="route" value="additem" />
			<label for="name" class="mar-1">
				Item Name : 
				<input type="text" required name="name" id="name" class="inp mar-l-1" />
			</label>
			<label for="name" class="mar-1">
				Item Unit : 
				<input type="text" required name="unit" id="unit" class="inp mar-l-1" />
			</label>
			<label for="price" class="mar-1">
				Item Name : 
				<input type="text" required name="price" id="price" class="inp mar-l-1" />
			</label>
			<label for="imageurl" class="mar-1">
				Item Name : 
				<input type="text" name="imageurl" id="imageurl" class="inp mar-l-1" value="" />
			</label>
			<input type="hidden" name="shopid" value="${shopid}" />
			<input type="submit" value="add" />
		</form>
	</div>
</body>
</html>