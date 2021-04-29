
<%@page import="java.util.List"%>
<%@page import="DatabaseLayer.StockWatch"%>
<%@page import="DatabaseLayer.userDetails"%>
<%@page import="Model.Stock"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	body{
	text-align:center;
	font-family:Monospace;
	
	 background-color:#333;
	 font-size:16px;
	 color:white
	}
	 select, #userPrice {
 height:30px;
 color:white;
 background-color:#ce1f6a;
 font-family:Monospace;
 width:200px;
 }
 select:focus, #userPrice{
 outline : none;
 }
 #next{
 	width:7%;
	height:30px;
	background-color:#ce1f6a;
	color:white;
		font-size : 16px;
 }
 .price{
 	height: 50px;
 }
 #submit{
 	width:8%;
	height:37px;
	font-family : Monospace;
	font-size : 16px;
	border-radius: 5px;
	background-color:green;
	color:white;
 }
 
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
 #submit:focus , #submit:hover {
  background-color: #228B22;
  color: White;
}
</style>
<title>Order</title>
</head>
<body>
  <%
  	String order = request.getParameter("orders");
  	String trade = request.getParameter("trades");
  	if(order!=null &&  trade!=null){
  		session.setAttribute("order", order);
  		session.setAttribute("trade", trade);
  	}

  	int id  = (int)session.getAttribute("userid");
  	double balance  = userDetails.getBalance(id);
  	%>
  	
  	<h2>Available Balance : <%=balance %></h2>
  	<form action='order.jsp'>
  
  	  <label for="stocks">Select The Stock :</label>
	  <select name="stock" id="stocks">
	   <% List<Stock> stock = StockWatch.getStocks();
	   			for(Stock s:stock){
	   				out.println("<option value="+s.getSymbol()+">"+s.getSymbol()+"</option>");
	   				
	   			}
	   %>
	  </select>
	  	<input type = 'hidden' name = 'trade' value = <%=trade %> />
  		<input type = 'hidden' name = 'order' value = <%=order %> />
	  <input id ='submit' style = "height:32px; width : 5%" type='submit' value= 'Next' />
  	</form>
  	<% String stockName = request.getParameter("stock"); 
	int stockid = 0;
	double price = 0;
  	if(stockName!=null){
  		
  		for(Stock s:stock){
  			
  			if(s.getSymbol().equalsIgnoreCase(stockName)){
  				stockid = s.getId();price =s.getLastTradedPrice();
  				%>
  				<p>Last Traded Price &#8669; <%=s.getLastTradedPrice() %></p> <br/>
  				<%
  				break;
  			}
  			
  		}
  		
  		%>
  		<form action='OrderPlaced.jsp' name ='userPrice' >
  		<input type = 'hidden' name = 'trade' value = <%=session.getAttribute("trade") %> />
  		<input type = 'hidden' name = 'order' value = <%=session.getAttribute("order")  %> />
  		<input type = 'hidden' name = 'stockid' value = <%=stockid  %> />
  		<input type = 'hidden' name = 'price' value = <%=price  %> />
  		<input type = 'hidden' name = 'stock' value = <%=stockName %> />
  		
  	  	<% if(request.getParameter("order").startsWith("L") || request.getParameter("order").startsWith("B")){ %>
  	  	 <p>Enter Trading Price &#9759; <p>
  	    <input id = 'userPrice'type = 'text' name='userPrice' />
  	    <%if(request.getParameter("order").startsWith("B")){ %>
  	     	 <p>Enter Target Price &#9759; <p>
  	    <input id = 'userPrice'type = 'text' name='userPriceTarget' />
  	    <%} %>
  	    <%} %>
  	    <p>Enter Quantity &#9759; </p>
  	     <input id = 'userPrice'type = 'number' name='userQty' /><br/><br/>
  	    <input id='submit' type = 'submit' value='Place Order' />
  	    <a class='button'href = 'http://localhost:8090/ShareMarketJSP/JSP/index.jsp'>Cancel Order</a>
  		</form>
  	<% }
  	%>
  

  	
  	
</body>
</html>