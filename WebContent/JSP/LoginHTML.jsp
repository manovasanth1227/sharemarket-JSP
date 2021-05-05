<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script type="text/javascript">


	const validate = () =>{
		const userId = document.login.userid.value;
		const userEmail = document.login.userName.value;	
		const userPassword = document.login.password.value;		
		if(!userId){
			alert("Enter valid UserId!");
			return false;
		}else if(!userEmail){
			alert("Enter valid Email Address!");
			return false;
		}else if(!userPassword){
			alert("Enter valid Password!");
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

form{
 display: flex;
 height:70vh;
 color:white;
 justify-content:center;
 flex-direction:column;
}

form> input{
	margin-bottom:20px;
	height:25px;
	width:500px;
	
	
}
input:focus{
outline:none;}
.submit{
	width:30%;
	height:8%;
	background-color:#ce1f6a;
	color:white;
}
span{
color :#ce1f6a;}
</style>
</head>
<body>
	<% 
	if(session.getAttribute("userid")==null){
		
		out.println("<form action= 'login.jsp' onSubmit = 'return validate()'  method='post' name='login' >");
		out.println("<h1>Login <span>&#8669;</span></h1>");
		out.println("UserId:"); 
		out.println("<input type = 'text' name='userid'/>");
		out.println(" Email Address:");
		out.println("<input type = 'email' name='userName'/>");
		out.println(" Password:"); 
		out.println("<input type = 'password' name='password'/>");
		out.println("<button class='submit' type = 'submit'>Login</button>");
		out.println("</form>");
	}else{
		response.sendRedirect("http://localhost:8090/ShareMarketJSP/JSP/index.jsp");
	}
	%>
</body>
</html>