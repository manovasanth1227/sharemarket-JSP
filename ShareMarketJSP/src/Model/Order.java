package Model;


public interface Order {
	public boolean marketOrder(int id , int stockid , String symbol ,  String investmentType ,String orderType, String orderOption , int qty);
	public boolean limitOrder(int id , int stockid ,String symbol ,  String investmentType ,String orderType, String orderOption , int qty , double price);
	public void bracketOrder(int id , int stockid ,String symbol ,  String investmentType ,String orderType, String orderOption , int qty , double price, double stoploss);
}
