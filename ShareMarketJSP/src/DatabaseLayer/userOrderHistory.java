package DatabaseLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.OrderModel;



public class userOrderHistory extends MySQLConnection  {
	private static Connection conn;
	private static List<OrderModel> orders = new ArrayList<OrderModel>();
	public static List<OrderModel> getHistory(int id) {
		
		if(conn==null)conn = establishConnection();
		orders.clear();
		try {
			Statement st =conn.createStatement();
			ResultSet rs = st.executeQuery("select * from orders where user_id="+id);
			while(rs.next()) {

				 orders.add( new OrderModel(rs.getInt(1), rs.getString(3), rs.getString(4) , rs.getString(5), rs.getString(6) , rs.getInt(7) , rs.getTimestamp(8)  +"")  );
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return orders;
	}
}
