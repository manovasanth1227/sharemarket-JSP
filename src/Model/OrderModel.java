package Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class OrderModel {
	@Id
	@Column(name="Id")
	@GeneratedValue
	private int id;
	@Column(name="User_Id", nullable = false)
	private int userId;
	@Column(name="Stock_Symbol" , nullable = false)
	private String stockName;
	@Column(name="Investment_type" , nullable = false)
	private String investmentType;
	@Column(name="Order_type" , nullable = false)
	private String orderType;
	@Column(name="Position", nullable = false)
	private String orderOption;
	@Column(name="Quantity", nullable = false)
	private int qty;
	@Column(name="Traded_Price", nullable = false)
	private double tradePrice;
	@Column(name="Placed_On" , nullable = false,columnDefinition = " TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	
	private String date;
	@Column(name="Executed", nullable = false )
	private String executed;
	
	public OrderModel() {}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getExecuted() {
		return executed;
	}
	public void setExecuted(String executed) {
		this.executed = executed;
	}
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", userId=" + userId + ", stockName=" + stockName + ", investmentType="
				+ investmentType + ", orderType=" + orderType + ", orderOption=" + orderOption + ", qty=" + qty
				+ ", tradePrice=" + tradePrice + ", date=" + date + ", executed=" + executed + "]";
	}
	public OrderModel( int userId, String stockName, String investmentType, String orderType, String orderOption,
			int qty, double tradePrice,  String executed) {
		super();
		
		this.userId = userId;
		this.stockName = stockName;
		this.investmentType = investmentType;
		this.orderType = orderType;
		this.orderOption = orderOption;
		this.qty = qty;
		this.tradePrice = tradePrice;
	
		this.executed = executed;
	}

	
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInvestmentType() {
		return investmentType;
	}
	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	


	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getOrderOption() {
		return orderOption;
	}
	public void setOrderOption(String orderOption) {
		this.orderOption = orderOption;
	}
	public double getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}
	
	
}
