package DatabaseLayer;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.OrderModel;



public class userOrderHistory   {
	private static  Session session ;

	private static List<OrderModel> orders = new ArrayList<OrderModel>();
	
	@SuppressWarnings("unchecked")
	public static List<OrderModel> getHistory(int id) {
		session = DBConnect.getSession();
		 session.beginTransaction();
		Query q = session.createQuery("from OrderModel where userId = " + id); 
		orders = q.list();
		session.close();
		return orders;
	}
	public static  boolean deleteHistoryById(int id) {
		
		List<OrderModel> orders= getHistory(id);
		boolean res = false;
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		for(OrderModel o : orders) {
			session.delete(o);
			res = true;
		}
		if(orders.size()==0) {
			res=true;
		}
		trans.commit();
		session.close();
		return res;
	}
	
}
