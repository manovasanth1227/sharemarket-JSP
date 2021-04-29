<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
  <%@ page import="Controller.userLoginController" session = 'true' errorPage='/HTML/loginError.html'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
			int id = Integer.parseInt(request.getParameter("userid"));
			String userName = request.getParameter("userName");
			String password  = request.getParameter("password");
			if(id!=0 && userName!=null && password!=null){
				if(userLoginController.loginController(id,userName,password)){
					session.setAttribute("userid", id);
					response.sendRedirect("http://localhost:8090/ShareMarketJSP/JSP/index.jsp");
				}else{
					out.println("Login UnSuccessfull");
						
				}
			}else{
				response.sendRedirect("http://localhost:8090/ShareMarketJSP/JSP/LoginHTML.jsp");
			}
	%>
</body>
</html>