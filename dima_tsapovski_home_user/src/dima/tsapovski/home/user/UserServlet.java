package dima.tsapovski.home.user;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dima.tsapovski.home.allUser.User;;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet({"/UserServlet", "/User"})
public class UserServlet extends HttpServlet {
	
	private Map<String, User> UserMap = new ConcurrentHashMap<String, User>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        UserMap.put("23", new User("Dmitry", "tsapovski@gmail.com", 27));
        UserMap.put("234", new User("Hippy", "Cl0ud@mail.ru", 23));
        UserMap.put("235", new User("Sally", "Sally@yandex.ru", 34));
       // UserMap.put("457", new User("Sal", "Sal@yandex.ru", 34));
        System.out.println("UserServlet created");
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
				"<title>User</title>"+
				"</head>"+
				"<body>"+
					"<h1>Welcome to room</h1>"+  
	"<table width=300 bgcolor=plum border=1 align= center cellspacing=10 cellpadding=center\">"+
				            
				      " <caption>AllUser</caption>"+
				      "		<thead>"+
				      " <tr>  <th>UserName  </th> <th>Mail </th><th>Age </th></tr>"+
				      
				      	      
				       "  </thead>");
				      
				//"<tbody>");
				         for(User p : UserMap.values()) {
							writer.append(
									 " <tr align= center valign= middle bgcolor= green \">"+
									 "<td>"+
				            "  <a href=\"/dima_tsapovski_home_user/DetailedInfo.html\">" + p.getUserName() + "</a>"+
				         " </td>"+
				         
				         " <td>" + p.getMail() + "</td>"+
				         " <td>" + p.getAge() + "</td>"+
				       " </tr>");
				         }
				 		writer.append(	
				 			//"		</tbody>"+
				 						"	</table>	"+
				 						"</body>"+
				 						"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

