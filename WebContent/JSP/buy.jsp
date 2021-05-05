<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Order</title>
</head>
<style>
 body{
 background-color:#333;
 height:30vh;
 color:white;
 display :flex;
 font-family:Monospace;
 font-size:16px;
 justify-content:center;
 align-items:center;
 }
 
 select {
 height:30px;
 color:white;
 background-color:#ce1f6a;
 font-family:Monospace;
 width:200px;
 }
 select:focus, input:focus {
 outline : none;}
 input{
 	width:30%;
	height:35px;
	background-color:#ce1f6a;
	color:white;
 }
 h1{
 	color:white;
 }
</style>



<body>
<%  
   if(session.getAttribute("userid")!=null){
	   Cookie cook = new Cookie("Options" , "Buying");
	   cook.setMaxAge(365 * 24 * 60 * 60);
	   response.addCookie(cook);
   %>  
<form action="order.jsp">
  <label for="trades">Choose a Trade :</label>
  <select name="trades" id="trade">
    <option value="MIS-Intrady">MIS-Intraday</option>
    <option value="CNC">CNC</option>
  </select>
  <br><br>
    <label for="orders">Choose a Order :</label>
  <select name="orders" id="order">
    <option value="Market Order">Market Order</option>
    <option value="Limit Order">Limit Order</option>
     <option value="Bracket Order">Bracket Order</option>
  </select>
  <br><br>
  <input type="submit" value="Next">
</form>

<%}
   else{
   response.sendRedirect("../HTML/loginFail.html");
   }
%>
 

</body>
</html>