

<%@page import="DatabaseLayer.StockWatch"%>
<%@page import="Model.Stock"%>
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
.buttong {
  background-color: green;  
  border-radius: 5px;
 
  color: white;
  padding: .5em;
  text-decoration: none;
}
	.buttong:focus,
.buttong:hover {
  background-color: #81b214;
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
		<table cellpadding = "10"  cellspacing = "15">
		<tr><th> StockId</th> <th>Symbol</th><th>Name</th><th>Last Traded Price</th><th>Sector Name</th><th>Volume</th>	</tr>
		<% List<Stock> stocks = StockWatch.getStocks();
			for(Stock s: stocks){
				%>
				<tr><td> <%=s.getId() %></td>  <td><%=s.getSymbol() %></td><td><%=s.getName() %></td><td><%=s.getLastTradedPrice() %></td><td><%=s.getSectorName() %></td><td><%=s.getVolume() %></td><td><form action="../adminUserRemove" method="get"><input type="hidden"value=<%=s.getId()  %> name="removeId"/> <input class="button button1"type="submit"value="Remove Stock"  /></form></td>    <td><form action="adminStockUpdate.jsp" ><input type="hidden"value=<%=s.getId()  %> name="updateId"/> <input class="buttong"type="submit"value="Update Stock"  /></form></td>	</tr>
				<%
			}
		%>
		<tr><td> </td>  <td> </td><td></td><td></td><td></td><td></td><td><form action="../HTML/newStock.html" method="post"> <input class="buttong"type="submit"value="Add New Stock"  /></form></td>	</tr>
		</table>
	</div>
	
	<% }else{%>
	<div style = "color : red;">Access Denied</div>
	<%} %>
	  
	  
</body>
</html>