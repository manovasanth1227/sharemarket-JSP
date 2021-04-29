package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.userRegistrationController;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName") + "";
		String adharNum = request.getParameter("adhar") +"";
		String panNum = request.getParameter("pan") +"";
		String bank = request.getParameter("bank") +"";
		String password = request.getParameter("password") +"";
		String confirmPassword = request.getParameter("confimPassword") +"";
		System.out.println(password +"!");
		System.out.println(confirmPassword+"!");
		boolean isValid = true;
		if(userName.isEmpty()) {
			isValid = false;
			out.println("Enter the valid user name!!</br>");
		}
		if(adharNum.isEmpty() || adharNum.length() <12) {
			isValid = false;
			out.println("Enter the valid Adhar Number (should contain 12 digits)!!</br>");
		}
		if(panNum.isEmpty()) {
			isValid = false;out.println("Enter the valid Pan Number!!</br>");
		}
		if(bank.isEmpty()) {
			isValid = false;
			out.println("Enter the valid bank name!!</br>");
		}
		
		if(password.length() < 8 ) {
			isValid = false;
			
			out.println(" Password Should contain atleast 8 characters, one LowerCase, UpperCase, Special Character, Number</br>  ");
		}
		if(!password.equals(confirmPassword)) {
			isValid = false;
			out.println("Password doesn't match !!</br>");
		}
		if(isValid) {
			int res = userRegistrationController.createUser(userName, adharNum, panNum ,  bank , password );
			if(res!=-1) {
				out.println("Resgistration Successfull <br/>");
				out.println("Your User ID ==>"+ res+" <br/>");
				out.println("<a href='http://localhost:8090/ShareMarketJSP/JSP/index.jsp'>Go to Home Screen</a>");
			}
		}else {
			out.println("<a href='http://localhost:8090/ShareMarketJSP/HTML/register.html'>Go to Register  Screen</a>");
		}
		
		
	}

}
