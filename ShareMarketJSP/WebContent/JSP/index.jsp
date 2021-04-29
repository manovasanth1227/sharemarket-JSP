<%@page import="Controller.userStocksController"%>
<%@page import="DatabaseLayer.userDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="Model.Stock"%>
 <%@page import="DatabaseLayer.StockWatch"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome DashBoard</title>
<style>
*{
margin:0px;
 background-color: #333;
padding:0px;
	font-family:Monospace;
	font-size:18px;
}
body{
display : flex;
align-items:center;
justify-content:center;
flex-direction: column;
color : white;
}
#navbar {
  background-color: #333; /* Black background color */
  width: 100%; /* Full width */
  height:8vh;
  display: flex;
  align-items:center;
  justify-content:center;
}

#navbar a {

  color: white;
  text-align: center;
  padding: 15px;
  text-decoration: none;
}
th{
color : #ce1f6a;
}

#navbar a:hover {
  background-color: #ddd;
  color: black;
}
span{
color:#ce1f6a;
}
td{
text-align:center;}
</style>
</head>

<body>
	<% int id =0;
	  if(session.getAttribute("userid") !=null)id= Integer.parseInt(session.getAttribute("userid") + ""); %>
	<div id="navbar">
	  <a href="LoginHTML.jsp">Login</a>
	  <a href="buy.jsp">Buy</a>
	  <a href="sell.jsp">Sell</a>
	
	  <a href="../HTML/deposit.html">Deposit</a>
	  <a href="../HTML/withdraw.html">Withdraw</a>
	  <% if(id==0){ %>
	  <a href="../HTML/register.html">New Registration</a><%}else{ %>
	   <a href="userStocks.jsp">MyStocks</a>
	   <a href="orderHistory.jsp">OrderHistory</a>
	  <%} %>
	    <a href="http://localhost:8090/ShareMarketJSP/logout">Logout</a>
	</div>
	 <%
	  if(id>0){ userStocksController.resetStock(id);%><p>Available Balance <span>&#8669;</span> <%=userDetails.getBalance(id) %></p><%} %>
	<div>
		<table cellpadding = "20"  cellspacing = "35">
		<tr><th> StockId</th> <th>Symbol</th><th>Name</th><th>Last Traded Price</th><th>Sector Name</th><th>Volume</th>	</tr>
		<% List<Stock> stocks = StockWatch.getStocks();
			for(Stock s: stocks){
				%>
				<tr><td> <%=s.getId() %></td> <td><%=s.getSymbol() %></td><td><%=s.getName() %></td><td><%=s.getLastTradedPrice() %></td><td><%=s.getSectorName() %></td><td><%=s.getVolume() %></td>	</tr>
				<%
			}
		%>
		</table>
	</div>
</body>
</html>