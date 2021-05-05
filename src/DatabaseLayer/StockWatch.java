package DatabaseLayer;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Stock;

public class StockWatch {
	private static List<Stock> stocks = new ArrayList<Stock>();
	private static  Session session ;
	@SuppressWarnings("unchecked")
	public static List<Stock> getStocks() {
		session = DBConnect.getSession();
		 session.beginTransaction();
		Query q = session.createQuery("from Stock "); 
		stocks = q.list();
		session.close();
		if(stocks.size()==0) {
			return null;
		}
		return stocks;
	
	}
	
	public static Stock getStock(int id) {
		session = DBConnect.getSession();
		 session.beginTransaction();
		
		Stock stock = (Stock) session.get(Stock.class, id);
		session.close();
		if(stock==null) {
			return null;
		}
		return stock;
	
	}
	public static boolean removeStock(int id) {
		session = DBConnect.getSession();
		Transaction trans = session.beginTransaction();
		
		Stock stock = (Stock) session.get(Stock.class, id);
		session.delete(stock);
		trans.commit();
		session.close();
		if(stock==null) {
			return false;
		}
		return true;
	
	}
	public static Stock addStock(String symbol , String name  ,double LTP , String sectorName , String volumne) {
		int size  = getStocks().size();
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		Stock s = new Stock(symbol, name, LTP, sectorName, volumne);
		session.save(s);
		trans.commit();
		session.close();
		if(getStocks().size() >size)return s;
		return null;

	}
	public static Stock updateStock(int id, String symbol , String name  ,double LTP , String sectorName , String volumne) {
		Stock stock = getStock(id);
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		if(stock!=null) {
			stock.setLastTradedPrice(LTP);
			stock.setName(name);
			stock.setSectorName(sectorName);
			stock.setSymbol(symbol);
			stock.setVolume(volumne);
			session.update(stock);
			trans.commit();
			session.close();
			return stock;
		}
		return null;

	}
	
	
	
}
