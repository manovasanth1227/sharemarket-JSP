package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.adminController;

/**
 * Servlet implementation class adminUserRemove
 */
public class adminUserRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminUserRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=-1;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = Integer.parseInt(request.getParameter("removeId"));
		if(id!=-1) {
			if(adminController.removeStock(id)) {
				response.sendRedirect("/ShareMarketJSP/HTML/removeStockSuccess.html");
			}else {
				out.println("Process Unsuccessful");
				out.println("<a href='/ShareMarketJSP/HTML/adminControl.html'>Go to Administration Controls Screen</a>");
			}
		}
		else response.sendRedirect("/ShareMarketJSP/HTML/loginFail.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=-1;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = Integer.parseInt(request.getParameter("removeId"));
		if(id!=-1) {
			if(adminController.removeUser(id)) {
				response.sendRedirect("/ShareMarketJSP/HTML/removeUserSuccess.html");
			}else {
				out.println("Process Unsuccessful");
				out.println("<a href='/ShareMarketJSP/HTML/adminControl.html'>Go to Administration Controls Screen</a>");
			}
		}
		else response.sendRedirect("/ShareMarketJSP/HTML/loginFail.html");
	}

}
