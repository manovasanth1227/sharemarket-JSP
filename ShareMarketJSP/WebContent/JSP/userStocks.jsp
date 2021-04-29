<%@page import="Controller.userStocksController"%>
<%@page import="Model.UserStock"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyStocks</title>
<style>
body{
display : flex;
align-items:center;
justify-content:center;
background-color:#333;
text-align:center;
font-family : Monospace;
font-size :16px;
flex-direction: column;
color : white;
}
th{
color : #ce1f6a;
}
td{
text-align:center;}
	 .button {
  background-color: Crimson;  
  border-radius: 5px;
  color: white;
  padding: .5em;
  text-decoration: none;
}
	.button:focus,
.button:hover {
  background-color: FireBrick;
  color: White;
}
span{
color:#ce1f6a;
}
</style>
</head>
<body>
	<div>
		<p style = 'font-size :25px; padding :0px; margin:0px; margin-top:20px; text-align :center;'>My Stocks <span>&#8669;</span></p>
		<% 
		
		List<UserStock> stocks = userStocksController.getUserStocks(Integer.parseInt(session.getAttribute("userid") + ""));
		if(stocks!=null){
			%>
			<table cellpadding = "10"  cellspacing = "20">
		<tr><th> StockId</th> <th>Symbol</th><th>Quantity</th></tr>
		<%
			for(UserStock s: stocks){
				%>
				<tr><td> <%=s.getStockId() %></td> <td><%=s.getStockName() %></td><td><%=s.getQty() %></td><td></tr>
				<%
			}
			}
		%></table>
		</div>
		<% if(stocks==null){
			
			
			%>
			<p>No Stocks Available</p>	
			
			<% 		}
		%>
		<div >
		
		<a class='button' style = 'width : 10%;  text-align : center;'href = 'http://localhost:8090/ShareMarketJSP/JSP/index.jsp'>Go Back To Home</a>
	</div>
		
	
</body>
</html>