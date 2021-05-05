<%@page import="DatabaseLayer.userDetails"%>
<%@page import="Model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administration Controls</title>
</head>
<style>
	*{
margin:0px;
 background-color: #333;
padding:0px;
	font-family:Monospace;
	font-size:18px;
}
a:hover {
  background-color: #ddd;
  color: black;
}
a {

  color: white;
  margin:10px;
  text-align: center;
  padding: 15px;
  text-decoration: none;
}
body{
display : flex;
align-items:center;
justify-content:center;
text-align:center;
flex-direction: column;
color : white;
}
#nav{
	height:10vh;
	display :flex;
}
.button {
  background-color: Crimson;  
  border-radius: 5px;
  color: white;
  padding: .5em;
  text-decoration: none;
}
	.button1:focus,
.button1:hover {
  background-color: FireBrick;
  color: White;
}


</style>
<body>
	<%boolean isAdmin =false; 
	String temp = session.getAttribute("admin") + "";
	  if(temp.startsWith("t")){
	  		isAdmin  = true;
	  }
	%>
	<div id="nav">
		<a href = "../JSP/index.jsp" >Home</a>
	<a href = "../JSP/adminUser.jsp" >User Controls</a>
	<a href = "../JSP/adminStock.jsp" >Stock Controls</a>

	</div>
	<%if(isAdmin){
		%>
		<div>
		<table cellpadding = "20"  cellspacing = "35">
		<tr><th>Id</th> <th>Name</th><th>Email</th><th>Bank Account</th><th>AdharCard Number</th><th>PanCard Number</th><th>Control</th>	</tr>
		<% List<User> users = userDetails.getUsers();
			for(User s: users){
				%>
				<tr><td> <%=s.getUserId() %></td>  <td><%=s.getUserName() %></td><td><%=s.getUserEmail() %></td><td><%=s.getUserBankAccount() %></td><td><%=s.getUserAdharCard() %></td><td><%=s.getUserPanCard() %></td><td><form action="../adminUserRemove" method="post"><input type="hidden"value=<%=s.getUserId()  %> name="removeId"/> <input class="button <%if(!s.getIsAdmin().startsWith("t")) {%>button1 <%}%>"type="submit"value="Remove User" <%if(s.getIsAdmin().startsWith("t")) {%>disabled <%} %> /></form></td>	</tr>
				<%
			}
		%>
		</table>
	</div>
	
	<% }else {%>
	<div style = "color : red;">Access Denied</div>
	  <%} %>
	  
</body>
</html>