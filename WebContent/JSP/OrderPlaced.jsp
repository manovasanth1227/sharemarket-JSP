
<%@page import="java.util.List"%>
<%@page import="Controller.OrderController"%>
<%@page import="DatabaseLayer.StockWatch"%>
<%@page import="Model.Stock"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
<style>
body{
padding :20px;
	text-align:center;
	font-family:Monospace;
	display : flex;
	align-items:center;
	justify-content:center;
	flex-direction: column;
	 background-color:#333;
	 font-size:16px;
	 color:white
	}
	#head{
	font-size:20px;
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
</style>
</head>
<body>
	<%
	int id  = (int)session.getAttribute("userid");
	String investmentType = request.getParameter("trade");
	String orderType = request.getParameter("order");
	double userPrice = 0;
	if(request.getParameter("userPrice")!=null) userPrice = Double.parseDouble(request.getParameter("userPrice")) ;
	int stockid = Integer.parseInt(request.getParameter("stockid"));
	String stockName = request.getParameter("stock");
	int  userQty = Integer.parseInt(request.getParameter("userQty"));
	if(userPrice==0){
		
		List<Stock> stocks = StockWatch.getStocks();
		for(Stock st : stocks){
			if(stockid==st.getId()){
				userPrice = st.getLastTradedPrice();
			}
		}
	}
	double totalPrice = Math.round(userPrice*userQty);
	Cookie c[]= request.getCookies();
	String orderOption = "";
	for(Cookie cook : c){
		if(cook.getName().equalsIgnoreCase("Options")){
			orderOption = cook.getValue();
			break;
		}
	}
	System.out.println(id + "  " + stockid+ "  "  +  stockName + "  "  + investmentType + "   "  + orderType +  "  " +  orderOption + "  " + userQty + "   " + userPrice);
	if(OrderController.buyOrder(id ,stockid, stockName , investmentType , orderType , orderOption, userQty, userPrice)){
		for(Cookie cook : c){
			if(cook.getName().equalsIgnoreCase("Options")){
				cook.setMaxAge(0);
				break;
			}
		}
		%>
		<div id="head">Order Details</div>
		<table cellpadding = "2" cellspacing="35">
		<tr><td>Stock ID : </td> <td><%=stockid %></td> </tr>
		<tr><td>Stock Name : </td> <td><%=stockName%></td> </tr>
		<tr><td>Investment Type : </td> <td><%=investmentType%></td> </tr>
		<tr><td>Order Type : </td> <td><%=orderType%></td> </tr>
		<tr><td>Call : </td> <td><%=orderOption %></td> </tr>
		<tr><td>Quantity : </td> <td><%=userQty%></td> </tr>
		<tr><td>price : </td> <td><%=userPrice%></td> </tr>
		<tr><td>Total Price : </td> <td><%=totalPrice %></td> </tr>
		</table>
		<a class='button'href = 'index.jsp'>Back</a>
		<%
	}else {
		out.println("<p>Order Unsuccessfull</p>");
	}
	%>
</body>
</html>