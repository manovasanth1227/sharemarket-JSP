package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DatabaseLayer.userDetails;

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int id = 0;
		if(session.getAttribute("userid")!=null) {
			id =Integer.parseInt(session.getAttribute("userid") + "");
		}else {
			 response.sendRedirect("http://localhost:8090/ShareMarketJSP/HTML/loginFail.html");
		}
		double balance = userDetails.getBalance(id);
		double amt  = 0;
		if(!request.getParameter("deposit").isEmpty()) {
			amt  = Double.parseDouble(request.getParameter("deposit")+"");
			int check = userDetails.deposit(id, amt, balance);
			if(check==1) {
				response.sendRedirect("http://localhost:8090/ShareMarketJSP/HTML/depositSuccess.html");
			}else {
				response.sendRedirect("http://localhost:8090/ShareMarketJSP/HTML/loginError.html");
			}
			
		}else {
			out.println("Enter a valid amount...");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int id = 0;
		if(session.getAttribute("userid")!=null) {
			id =Integer.parseInt(session.getAttribute("userid") + "");
		}else {
			 response.sendRedirect("http://localhost:8090/ShareMarketJSP/HTML/loginFail.html");
		}
		double balance = userDetails.getBalance(id);
		double amt  = 0;
		if(!request.getParameter("withdraw").isEmpty()) {
			amt  = Double.parseDouble(request.getParameter("withdraw")+"");
			if(amt <= balance) {
				int check = userDetails.withdraw(id, amt, balance);
				if(check==1) {
					response.sendRedirect("http://localhost:8090/ShareMarketJSP/HTML/withdrawSuccess.html");
				}else {
					response.sendRedirect("http://localhost:8090/ShareMarketJSP/HTML/loginError.html");
				}
			}
		}
		out.println("Enter a valid amount...");
		
	}

}
