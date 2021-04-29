package Model;

public class UserStock {
	private int stockId;
	private String stockName;
	private int qty;
	public UserStock(int stockId, String stockName, int qty) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "UserStock [stockId=" + stockId + ", stockName=" + stockName + ", qty=" + qty + "]";
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
