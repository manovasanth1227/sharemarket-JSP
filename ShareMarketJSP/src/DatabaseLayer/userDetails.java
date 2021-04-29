package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDetails extends MySQLConnection{
	private static Connection conn;
	
	
	public static double getBalance(int id) {
		double balance = 0;
		if(conn==null) conn = establishConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select balance from users where id=" + id);
			rs.next();
			balance = rs.getFloat(1);
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return Math.round(balance*100.00)/100.0;
		
	}
	public static int  setBalance(int id, double balance) {
		if(conn==null) conn = establishConnection();
		try {
			PreparedStatement pt = conn.prepareStatement("UPDATE USERS SET balance = (?) where id =(?);");
			pt.setDouble(1, balance);
			pt.setInt(2, id);
			return pt.executeUpdate();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return 0;
		
	}
	public static int withdraw(int id ,double amt,  double balance) {
		if(conn==null) conn = establishConnection();
		int res =0;
		try {
			PreparedStatement pt = conn.prepareStatement("UPDATE USERS SET balance = (?) where id =(?);");
			pt.setDouble(1, balance -  amt);
			pt.setInt(2, id);
			res = pt.executeUpdate();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		return res;
	}
	public static int deposit(int id ,double amt,  double balance) {
		if(conn==null) conn = establishConnection();
		int res =0;
		try {
			PreparedStatement pt = conn.prepareStatement("UPDATE USERS SET balance = (?) where id =(?);");
			pt.setDouble(1, balance + amt);
			pt.setInt(2, id);
			res = pt.executeUpdate();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		return res;
	}
	
	public static int [] newUser( String userName , String userPassword,String userBankAccount,String userAdharCard,String userPanCard) {
		if(conn==null)conn = establishConnection();
	 	int id = 0;
	 	int newid=0;
	 	try {
			Statement stmt=(Statement) conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select count(id) from users;");  
			rs.next();
			id = rs.getInt(1);
			PreparedStatement pt = conn.prepareStatement("insert into users(id, user_name , password, bank,adhar_card,pan_card) values(?,?,?,?,?,?)");
			pt.setInt(1, id+1);
			pt.setString(2, userName);
			pt.setString(3, userPassword);
			pt.setString(4, userBankAccount);
			pt.setString(5, userAdharCard);
			pt.setString(6, userPanCard);
			pt.executeUpdate();
			rs = stmt.executeQuery("select count(id) from users;");
			rs.next();
			newid = rs.getInt(1);
		}
		catch (SQLException e1) {
				e1.printStackTrace();
		}
		return new int[] {newid,id};
	}
}
