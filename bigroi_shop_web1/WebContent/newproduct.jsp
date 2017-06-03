<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New product</title>
</head>
<body>
	<h3>New product</h3>
	<form method="post" action="/bigroi_shop_web1/createproduct">
		Code: <input name="code" type="text"/>
		Name: <input name="name" type="text"/>
		Price: <input name="price" type="text"/>
		<br/><br/>
		<input type="submit" value="Create"/>
	</form>
</body>
</html>