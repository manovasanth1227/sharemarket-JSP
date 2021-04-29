package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class addOrder extends MySQLConnection {
	private static Connection conn = null;
	
	public static int insert(int id , String symbol, String investmentType , String orderType , String orderOption , int qty) {
		if(conn==null) conn= establishConnection();
		
		ResultSet rs;
		try {
			Statement stmt=(Statement) conn.createStatement();  
			rs = stmt.executeQuery("select count(id) from orders;");
			rs.next();
			int size = rs.getInt(1) +1;
			PreparedStatement pt = conn.prepareStatement("INSERT INTO ORDERS(id , user_id , stock_name , investment_type , order_type , order_option,qty, order_date) VALUES(?,?,?,?,?,?, ?, CURRENT_TIMESTAMP)");
			pt.setInt(1, size);
			pt.setInt(2, id);
			pt.setString(3, symbol);
			pt.setString(4, investmentType);	pt.setString(5, orderType);	pt.setString(6, orderOption);
			pt.setInt(7, qty);
			int res = pt.executeUpdate();
		
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return 0;
		
	}
}
