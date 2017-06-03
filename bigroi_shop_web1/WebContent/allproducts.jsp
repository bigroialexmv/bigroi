<%@page import="com.bigroi.shop.model.Product"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%Map<String, Product> codeProductMap = (Map<String, Product>) request.getAttribute("products");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>

	<h3>Welcome to E-Shop</h3>
	<table style="width: 100%;">
		<caption style="font-weight: bold;">Products</caption>
		<thead>
			<tr>
				<th style="text-align: left;">Code</th>
				<th style="text-align: left;\">Name</th>
				<th style="text-align: right;">Price</th>
			</tr>
		</thead>
		<tbody>			
			<%for(Product p : codeProductMap.values()) { %>
			<tr>
				<td style="text-align: left;">
					<a href="/bigroi_shop_web1/product?code=<%=p.getCode()%>"><%=p.getCode()%></a>
				</td>
				<td style="text-align: left;">
					<%=p.getName()%>
				</td>
				<td style="text-align: left;">
					<%=p.getPrice()%>
				</td>
			</tr>
			<%} %>
		</tbody>		
	</table>
	<a href="/bigroi_shop_web1/newproduct.jsp">New product</a>
</body>
</html>