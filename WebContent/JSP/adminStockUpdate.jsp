
<!DOCTYPE html>
<%@page import="DatabaseLayer.StockWatch"%>
<%@page import="Model.Stock"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Updating</title>
<script type="text/javascript">

	const validate = ()=>{

		const id =  document.stock.id.value;
		const symbol = document.stock.symbol.value;
		const name = document.stock.name.value;
		const LTP = document.stock.LTP.value;
		const sectorName = document.stock.sectorName.value;
		const volume = document.stock.volume.value;
		console.log({
			id, symbol,name,LTP,sectorName,volume
			})
		if(!symbol){
			alert("Enter valid symbol!");
			return false;
		}
		else if(!name){
			alert("Enter valid name!");
			return false;
		}else if(!LTP){
			alert("Enter valid LTP!");
			return false;
		}else if(!sectorName){
			alert("Enter valid sectorName!");
			return false;
		}else if(!volume){
			alert("Enter valid volume!");
			return false;
		}
		return true;
		
		}
</script>
<style>
body{
display:flex;
align-items:center;
justify-content:center;
color:black;
flex-direction:column;
background-color: #333;
	font-family:Monospace;
}
input:focus{
outline :none;
}

form{
 display: flex;

 color:white;
 font-family:Monospace;
 justify-content:center;
 flex-direction:column;
}

form> input{
	margin-bottom:20px;
	height:25px;
	width:500px;
	
	
}
span{
color : #ce1f6a;
}
 .submit{
 	width:30%;
	height:37px;
	font-family : Monospace;
	font-size : 16px;
	border-radius: 5px;
	background-color:green;
	color:white;
 }
 

 .submit:focus , .submit:hover {
  background-color: #228B22;
  color: White;
}
</style>
</head>
<body>
		<%
			Stock stock = null;
			int id = Integer.parseInt(request.getParameter("updateId"));
			stock = StockWatch.getStock(id);
		
		%>
		<%if(stock!=null){ %>
       <form  action  = "addStockServlet.jsp" onSubmit  = "return validate()"  name='stock' >
		<h1>Stock Update<span>&#8669;</span></h1>
		<br/>>
			<input type="hidden" value=<%=id %> name="id" />
			Enter Stock Symbol &#8669;
			<input type = 'text' name='symbol' value =<%=stock.getSymbol().toString()%> autocomplete="off"/>
			Enter Stock Name &#8669;
			<input type = 'text' name='name' value =<%=stock.getName().toString().replaceAll("\\s", "")%> />
			Enter Stock Sector Name &#8669;
			<input type = 'text' name='sectorName' value =<%=stock.getSectorName().toString().replaceAll("\\s", "")%> autocomplete="off"/>
			Enter Stock Listing Price &#8669;
			<input type = 'text' name='LTP' value =<%=stock.getLastTradedPrice()%> autocomplete="off"/>
			Enter Stock Volume &#8669;
			<input type = 'text' name='volume' value =<%=stock.getVolume().toString().replaceAll("\\s", "")%> autocomplete="off"/>
		<button class='submit' type = 'submit'>Update Stock</button>

		</form>;
		<%} %>
</body>
</html>