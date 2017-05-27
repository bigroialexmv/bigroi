package com.bigroi.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigroi.shop.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	
	private Map<String, Product> codeProductMap = new ConcurrentHashMap<String, Product>();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        codeProductMap.put("001", new Product("001", "Nokia", 200));
        codeProductMap.put("002", new Product("002", "iPhone", 500));
        codeProductMap.put("003", new Product("003", "HTC", 400));
        codeProductMap.put("004", new Product("004", "Sumsung", 300));
        System.out.println("ProductServlet created");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.append(
				"<!DOCTYPE html>"+
						"<html>"+
						"<head>"+
						"<meta charset=\"UTF-8\"/>"+
						"<title>E-Shop</title>"+
						"</head>"+
						"<body>"+
						"	<h3>Welcome to E-Shop</h3>"+
						"	<table style=\"width: 100%; \">"+
						"		<caption style=\"font-weight: bold;\">Products</caption>"+
						"		<thead>"+
						"			<tr>"+
						"				<th style=\"text-align: left;\">Code</th>"+
						"				<th style=\"text-align: left;\">Name</th>"+
						"				<th style=\"text-align: right;\">Price</th>"+
						"			</tr>"+
						"		</thead>"+
					"		<tbody>");
		for(Product p : codeProductMap.values()) {
			writer.append(
					"			<tr>"+
					"				<td>" + p.getCode() + "</td>"+
					"				<td>"+
					"					<a href=\"/bigroi_shop_web1/nokia.html\">" + p.getName() + "</a>"+
					"				</td>"+
					"				<td style=\"text-align: right;\">" + p.getPrice() + "</td>"+
					"			</tr>");
		}
		writer.append(			
				"		</tbody>"+
				"	</table>	"+
				"</body>"+
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}