<%@page import="Model.OrderModel"%>
<%@page import="java.util.List"%>
<%@page import="DatabaseLayer.userOrderHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderHistory</title>
<style>
body{
display : flex;
align-items:center;
justify-content:center;
background-color:#333;
font-family : Monospace;
font-size :16px;
text-align:center;
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
td{
text-align:center;}
</style>
</head>
<body>
<% int id =0;
	  if(session.getAttribute("userid") !=null)id= Integer.parseInt(session.getAttribute("userid") + ""); %>
	  
	  <div>
	  <%List<OrderModel> orders = userOrderHistory.getHistory(id);
		if(orders.size()!=0){
		%>
	  <p style = 'font-size :25px; padding :0px; margin:0px; margin-top:20px; text-align :center;'>Order History <span>&#8669;</span></p>
		<table cellpadding = "10"  cellspacing = "15">
		
		<tr><th> OrderID</th> <th>Symbol</th><th>InvestmentType</th><th>OrderType</th><th>OrderOption</th><th>Quantity</th>	<th>Traded Price</th><th>Order Placed At</th><th>Order Position</th></tr>
		<% 
			for(OrderModel s: orders){
				%>
                 <tr><td> <%=s.getId() %></td> <td><%=s.getStockName() %></td><td><%=s.getInvestmentType() %></td><td><%=s.getOrderType() %></td><td><%=s.getOrderOption()  %></td><td><%=s.getQty() %></td><td><%=s.getTradePrice() %></td><td><%=s.getDate() %></td><td><%=s.getExecuted() %></td></tr>
				<%
			}
		}
		%>
		</table>
		<%if(orders.size()==0){
			out.println("<p>No Orders History Available </p>");
			
			
		}%>
		<a class='button' style = 'width : 10%; text-align : center;'href = 'index.jsp'>Go Back To Home</a>
	</div>
</body>
</html>