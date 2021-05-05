<%@page import="Controller.adminController"%>
<%@page import="Model.Stock"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Listing</title>
</head>
<body>
<%
int id = -1;
if(request.getParameter("id")!=null)id = Integer.parseInt(request.getParameter("id"));
String symbol = request.getParameter("symbol") + "";
String name = request.getParameter("name") + "";
String sectorName = request.getParameter("sectorName") +"";
String LTP = request.getParameter("LTP") +"";
String volume = request.getParameter("volume") +"";
boolean isValid = true;
if(LTP.isEmpty()) {
	isValid = false;
	
}

if(symbol.isEmpty()) {
	isValid = false;
	
}
if(name.isEmpty()) {
	isValid = false;
	
}
if(sectorName.isEmpty()) {
	
}
if(volume.isEmpty()) {
	isValid = false;
	
}
if(isValid) {
	double price = Double.parseDouble(LTP);
	Stock stock = null;
	if(id==-1){
	 stock = adminController.addStock(symbol, name, price, sectorName, volume);
	}else if(id>=0){
		stock = adminController.updateStock(id, symbol, name, price, sectorName, volume);
	}
	if(stock!=null) {
		
		out.println("Stock Added Successfull<br/>");
		out.println(stock.toString() + "<br/>");
		out.println("<a href='/ShareMarketJSP/HTML/adminControl.html'>Go to Administration Controls Screen</a>");
	}
}else {
	out.println("Process Unsuccessful");
	out.println("<a href='/ShareMarketJSP/HTML/adminControl.html'>Go to Administration Controls Screen</a>");
}

%>
</body>
</html>