package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="Id")
	private int userId;
	@Column(name="User_Email")
	private String userEmail;
	@Column(name="Password")
	private String userPassword;
	@Column(name="Bank")
	private String userBankAccount;
	@Column(name="Adhar_Card")
	private String userAdharCard;
	@Column(name="Pan_Card")
	private String userPanCard;
	@Column(name="User_Name")
	private String userName;
	@Column(name="Balance")
	private double balance;
	@Column(name="isAdmin")
	private String isAdmin; 

	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getUserId() {
		return userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User() {
		
	}



	public User( int userId , String userEmail, String userPassword, String userBankAccount, String userAdharCard,
			String userPanCard, String userName) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userBankAccount = userBankAccount;
		this.userAdharCard = userAdharCard;
		this.userPanCard = userPanCard;
		this.userName = userName;
		this.balance = 0.0;
		this.isAdmin = "false";
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserBankAccount() {
		return userBankAccount;
	}
	public void setUserBankAccount(String userBankAccount) {
		this.userBankAccount = userBankAccount;
	}
	public String getUserAdharCard() {
		return userAdharCard;
	}
	public void setUserAdharCard(String userAdharCard) {
		this.userAdharCard = userAdharCard;
	}
	public String getUserPanCard() {
		return userPanCard;
	}
	public void setUserPanCard(String userPanCard) {
		this.userPanCard = userPanCard;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userFullName) {
		this.userName = userFullName;
	}
	
	
	
	
	
}
