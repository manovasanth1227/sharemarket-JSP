package Model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user_stock")
public class UserStock {
	@Id
	private int id; 
	@Column(name="stockId")
	private int stockId;
	@Column(name ="user_id")
	private int userId;
	@Column(name ="stock_name")
	private String stockName;
	@Column(name ="qty")
	private int qty;
	
	public UserStock() {}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserStock(int stockId, int user_id, String stockName, int qty) {
		super();
		this.userId = user_id;
		this.stockId = stockId;
		this.stockName = stockName;
		this.qty = qty;
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
