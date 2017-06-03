<%@page import="com.morozov.shop.web.Product"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<%Map<String, Product> codeProductMap = (Map<String,Product>)request.getAttribute("products");%>
	
	<%for(Product p : codeProductMap.values()) { %>
<%-- 		Code <%=i%> --%>
		<br/>
	<%} %>
</body>
</html>