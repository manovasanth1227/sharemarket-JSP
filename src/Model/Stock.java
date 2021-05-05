package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="stock")
public class Stock {
	@Id
	@Column(name="Id")
	private int id;
	@Column(name= "Symbol")
	private String symbol;
	@Column(name= "Name")
	private String name;
	@Column(name= "LTP")
	private double lastTradedPrice;
	@Column(name= "Sector_Name")
	private String sectorName;
	@Column(name = "Volume")
	private String volume;
	public Stock() {}
	public Stock(String symbol, String name, double lastTradedPrice, String sectorName, String volume) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.lastTradedPrice = lastTradedPrice;
		this.sectorName = sectorName;
		this.volume = volume;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Stock [ID= "+getId()+" SYMBOL=" + symbol + ", NAME=" + name + ", lastTradedPrice=" + lastTradedPrice + ", SECTORNAME="
				+ sectorName + ", VOLUME=" + volume + "]";
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLastTradedPrice() {
		return lastTradedPrice;
	}
	public void setLastTradedPrice(double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
}
