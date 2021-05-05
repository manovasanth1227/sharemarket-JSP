package BussinessLogic;




import Controller.userStocksController;

import DatabaseLayer.StockWatch;
import DatabaseLayer.addOrder;
import DatabaseLayer.userDetails;
import Model.Order;
import Model.UserStock;

public class BuyOrder  implements Order{
	

	@Override
	public boolean marketOrder(int id , int stockid ,String symbol ,  String investmentType ,String orderType, String orderOption , int qty) {
		
		double balance = userDetails.getBalance(id);
		double price = StockWatch.getStock(stockid).getLastTradedPrice();;
		int prev = 0;
		int res1 = 0;
		int res2=0;
		double totalPrice = qty*price;
		if(totalPrice > balance && !orderOption.equalsIgnoreCase("Selling")) {
			System.out.println("===================Error: Not Available Balance===================");
			return false;
		}
		else {
			res2 = addOrder.insert(id, symbol, investmentType, orderType, orderOption, qty,price,"Completed");
			if(orderOption.equalsIgnoreCase("Selling")) {
				double newBal = balance + totalPrice;
				userDetails.setBalance(id, newBal);
			}
			else {
				double newBal = balance - totalPrice;
				userDetails.setBalance(id, newBal);
			}
			UserStock stock = userStocksController.getUserStock(id, stockid);
			if(stock!=null) {
				prev = stock.getQty();
			}
			
			if(orderOption.equals("Selling") ) {
				if(prev==0) {
					qty = - qty;
					res1 = userStocksController.insertStock(id, stockid, qty, symbol);
				}else {
					qty = prev - qty;
					res1 = userStocksController.updateUserStock(id, stockid, qty);
				}
			}
			else {
				if(prev==0) {
					res1 = userStocksController.insertStock(id, stockid, qty, symbol);
				}else {
					qty = prev + qty;
					res1 = userStocksController.updateUserStock(id, stockid, qty);
				}
			}
			
			
			if(res1==1 && res2==1) {
				System.out.println("===================Order Successfull===================");
				return true;
				
			}else {
				System.out.println("===================Order Unsuccessfull===================");
				return false;
			}
			
		}
	}
	
	
	@Override
	public boolean limitOrder(int id , int stockid ,String symbol ,  String investmentType ,String orderType, String orderOption , int qty , double price) {

		
		int prev = 0;
		int res1 = 0;
		int res2 = 0;
		
		double balance  = userDetails.getBalance(id);
		
		double totalPrice = qty*price;
		if(totalPrice > balance && !orderOption.equalsIgnoreCase("Selling")) {
			System.out.println("===================Error: Not Available Balance===================");
			return false;
		}
		res2 = addOrder.insert(id, symbol, investmentType, orderType, orderOption, qty, price , "Completed");
		if(orderOption.equalsIgnoreCase("Selling")) {
			double newBal = balance + totalPrice;
			userDetails.setBalance(id, newBal);
		}
		else {
			double newBal = balance - totalPrice;
			userDetails.setBalance(id, newBal);
		}
		UserStock stock = userStocksController.getUserStock(id, stockid);
		if(stock!=null) {
			prev = stock.getQty();
		}
		
		if(orderOption.equals("Selling") ) {
			if(prev==0) {
				qty = - qty;
				res1 = userStocksController.insertStock(id, stockid, qty, symbol);
			}else {
				qty = prev - qty;
				res1 = userStocksController.updateUserStock(id, stockid, qty);
			}
		}
		else {
			if(prev==0) {
				res1 = userStocksController.insertStock(id, stockid, qty, symbol);
			}else {
				qty = prev + qty;
				res1 = userStocksController.updateUserStock(id, stockid, qty);
			}
		}
		
		
		if(res1==1 && res2==1) {
			System.out.println("===================Order Successfull===================");
			return true;
			
		}else {
			System.out.println("===================Order Unsuccessfull===================");
			return false;
		}
		
		
	}



	@Override
	public void bracketOrder(int id , int stockid ,String symbol ,  String investmentType ,String orderType, String orderOption , int qty , double price , double stoploss ) {
		// TODO Auto-generated method stub
		BuyOrder obj = new BuyOrder();
		
		obj.limitOrder(id, stockid, symbol, investmentType, orderType, orderOption, qty, price);
		
		if(orderOption.startsWith("B")) {
			obj.limitOrder(id, stockid, symbol, investmentType, orderType, "Selling", qty, stoploss);
		}else {
			obj.limitOrder(id, stockid, symbol, investmentType, orderType, "Buying", qty, stoploss);
		}
		
		
	}

}
