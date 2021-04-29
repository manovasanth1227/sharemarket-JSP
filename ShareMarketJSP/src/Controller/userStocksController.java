package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DatabaseLayer.MySQLConnection;
import Model.UserStock;

public class userStocksController extends MySQLConnection{
	private static Connection conn;
	private static List<UserStock> userstocks = null;
	public static List<UserStock>  getUserStocks(int id) {
		if(conn==null) conn = establishConnection();
		int f =0;
		if(userstocks!=null) {
			userstocks.clear();
		}else {
			userstocks = new ArrayList<>();
		}
		try {
			Statement st = conn.createStatement();
			ResultSet rs  =st.executeQuery("select * from user_stock where user_id = "+id);  
			while(rs.next()) {
				f=1;
				 userstocks.add(new UserStock(rs.getInt(1), rs.getString(3) ,rs.getInt(4)));
			}
			if(f==0) {
				return null;
			}else {
				return userstocks;
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return userstocks;
	}
	public static UserStock getUserStock(int id, int stockid) {
		if(conn==null) conn = establishConnection();
		UserStock  stock = null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs  =st.executeQuery("select * from user_stock where user_id = "+id + " and stockId =" + stockid);  
			while(rs.next()) {
				 stock = (new UserStock(rs.getInt(1), rs.getString(3) ,rs.getInt(4)));
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return stock;
		
	}
	public static int updateUserStock(int id, int stockid, int qty) {
		if(conn==null) conn = establishConnection();
		int res = 0;
		try {
			
			PreparedStatement pt = conn.prepareStatement("UPDATE USER_STOCK  SET qty=(?) where user_id = (?) and stockId = (?)");
			pt.setInt(1, qty);
			pt.setInt(2, id);
			pt.setInt(3, stockid);
			 res = pt.executeUpdate();
			
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return res;
	}
	public static int insertStock(int id, int stockid, int qty, String symbol) {
		if(conn==null) conn = establishConnection();
		int res = 0;
		try {
			
			PreparedStatement pt = conn.prepareStatement("INSERT INTO USER_STOCK(stockId , user_id, stock_name ,qty) VALUES(?,?,?,?);");
			pt.setInt(1, stockid);
			pt.setInt(2, id);
			pt.setString(3,symbol);
			pt.setInt(4, qty);
			res = pt.executeUpdate();
			
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return res;

	}
	public static void resetStock(int id) {
		if(conn==null) conn = establishConnection();
		
		try {
			
			PreparedStatement pt = conn.prepareStatement("DELETE FROM USER_STOCK where qty = 0 and user_id = " +id );
			
			 pt.executeUpdate();
			
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
