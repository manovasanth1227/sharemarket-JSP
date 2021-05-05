package Controller;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DatabaseLayer.DBConnect;

import Model.UserStock;

public class userStocksController {
	
	private static  Session session ;
	private static List<UserStock> userstocks = null;
	
	@SuppressWarnings("unchecked")
	public static List<UserStock>  getUserStocks(int id) {	
		if(userstocks!=null) {
			userstocks.clear();
		}else {
			userstocks = new ArrayList<>();
		}
		
		session = DBConnect.getSession();
		 session.beginTransaction();
		 
		
		Query q  =  session.createQuery("from UserStock where userId = " + id);
		userstocks  = q.list();
		
		session.close();
		return userstocks;
	}
	@SuppressWarnings("unchecked")
	public static UserStock getUserStock(int id, int stockid) {
		
		session = DBConnect.getSession();
		 session.beginTransaction();
		 
		
		Query q  = session.createQuery("from UserStock where stockId = " + stockid+" and userId = " + id);
		List<UserStock> us = q.list();
		
		if(us.size()==1) {
			return us.get(0);
		}
		session.close();
		return null;
		
	}
	@SuppressWarnings("unchecked")
	public static int updateUserStock(int id, int stockid, int qty) {
		 
		UserStock user = null;
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		 
		int res = 1;
		Query q  =  session.createQuery("from UserStock where stockId = " + stockid+" and userId = " + id);
		List<UserStock> us = q.list();
		if(us.size()==1) {
			user = us.get(0);
			user.setQty(qty);
		}
		if(user!=null) {
			if(user.getQty()==0) {
				session.delete(user);
			}else {
				session.update(user);
			}
			
		}else {
			res=0;
		}

		trans.commit();
		session.close();
		
		return res;

	}
	public static int insertStock(int id, int stockid, int qty, String symbol) {
		
		UserStock us = null;
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		 
		
		us = new UserStock(stockid, id, symbol, qty);
		session.save(us);
		trans.commit();
		session.close();
		
		return 1;

	}
	public static boolean deleteStockByUserId(int id) {
		List<UserStock> stocks =   getUserStocks(id);
		boolean res = false;
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		 
		for(UserStock stock : stocks) {
			session.delete(stock);
			res = true;
		}
		if(stocks.size()==0) {
			res = true;
		}
		
		
		trans.commit();
		session.close();
		return res;
	}
}
