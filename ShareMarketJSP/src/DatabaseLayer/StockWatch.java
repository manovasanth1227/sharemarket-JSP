package DatabaseLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Model.Stock;
public class StockWatch extends MySQLConnection {
	private static List<Stock> stocks = new ArrayList<Stock>();
	private static Connection conn;
	public static List<Stock> getStocks() {
		if(conn==null)conn = establishConnection();
		stocks.clear();
		try {
			Statement stmt=(Statement) conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from stock");  
			while(rs.next()) {
				int id = rs.getInt(1);
				String symbol = rs.getString(2);
				String name = rs.getString(3);
				double LTP =  Math.round(rs.getFloat(4) * 100D) / 100D; 
				String sectorName = rs.getString(5);
				int volume  = rs.getInt(6);
				stocks.add(new Stock(id,symbol,name,LTP,sectorName,volume +""));	
			}
			
	
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		return stocks;
	
	}
}
