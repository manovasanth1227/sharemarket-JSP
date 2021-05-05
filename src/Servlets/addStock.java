package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.adminController;

import Model.Stock;

/**
 * Servlet implementation class addStock
 */
public class addStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String symbol = request.getParameter("symbol") + "";
		String name = request.getParameter("name") + "";
		String sectorName = request.getParameter("sectorName") +"";
		String LTP = request.getParameter("LTP") +"";
		String volume = request.getParameter("volume") +"";
		boolean isValid = true;
		if(LTP.isEmpty()) {
			isValid = false;
			out.println("Enter the valid stock price!!</br>");
		}
		
		if(symbol.isEmpty()) {
			isValid = false;
			out.println("Enter the valid stock symbol!!</br>");
		}
		if(name.isEmpty()) {
			isValid = false;
			out.println("Enter the valid stock Name !!</br>");
		}
		if(sectorName.isEmpty()) {
			isValid = false;out.println("Enter the valid stock sector name!!</br>");
		}
		if(volume.isEmpty()) {
			isValid = false;
			out.println("Enter the valid stock volume!!</br>");
		}
		if(isValid) {
			double price = Double.parseDouble(LTP);
			Stock stock = adminController.addStock(symbol, name, price, sectorName, volume);
			if(stock!=null) {
				
				out.println("Stock Added Successfull<br/>");
				out.println(stock.toString() + "<br/>");
				out.println("<a href='/ShareMarketJSP/HTML/adminControl.html'>Go to Administration Controls Screen</a>");
			}
		}else {
			out.println("Process Unsuccessful");
			out.println("<a href='/ShareMarketJSP/HTML/adminControl.html'>Go to Administration Controls Screen</a>");
		}
		
		
		
	}

}
