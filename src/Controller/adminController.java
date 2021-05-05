package Controller;

import DatabaseLayer.StockWatch;
import DatabaseLayer.userDetails;
import DatabaseLayer.userOrderHistory;
import Model.Stock;

public class adminController  {
	public static boolean removeUser(int id) {
		boolean res1 = userOrderHistory.deleteHistoryById(id); 
		boolean res2 = userDetails.deleteUserById(id);
		boolean res3 = userStocksController.deleteStockByUserId(id);
		return res1 && res2 &&  res3;
	}
	public static boolean removeStock(int id) {
		return StockWatch.removeStock(id);
	}
	public static Stock addStock(String symbol , String name , double LTP ,  String sectorName , String volume) {
		return StockWatch.addStock(symbol, name, LTP, sectorName, volume);
	}
	public static Stock updateStock(int id , String symbol , String name , double LTP ,  String sectorName , String volume) {
		return StockWatch.updateStock(id,symbol, name, LTP, sectorName, volume);
	}
}
