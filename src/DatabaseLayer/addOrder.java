package DatabaseLayer;



import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.OrderModel;

public class addOrder  {
	private static  Session session ;
	
	public static int insert(int id , String symbol, String investmentType , String orderType , String orderOption , int qty, double price, String executed) {
		int size  = userOrderHistory.getHistory(id).size();
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		OrderModel order = new OrderModel(id, symbol, investmentType, orderType, orderOption, qty, price, executed);
		session.save(order);
		trans.commit();
		session.close();
		if(userOrderHistory.getHistory(id).size() > size) {
			return  1;
		}
		return 0;
		
	}
}
