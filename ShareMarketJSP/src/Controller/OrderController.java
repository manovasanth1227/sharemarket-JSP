package Controller;




import BussinessLogic.BuyOrder;

public class OrderController extends BuyOrder {
	public static boolean buyOrder(int id ,int stockid, String stockName ,  String investmentType ,String orderType, String orderOption , int qty, double userPrice) {
		BuyOrder obj = new BuyOrder();
		if(orderType.equalsIgnoreCase("market")) {
			return obj.marketOrder(id, stockid , stockName ,investmentType,orderType,orderOption,qty);
		}else if(orderType.equalsIgnoreCase("limit")) {
			return obj.limitOrder(id, stockid, stockName, investmentType, orderType, orderOption, qty, userPrice);
		}else if(orderType.equalsIgnoreCase("bracket")) {
			
		}
		return false;
	}
}
