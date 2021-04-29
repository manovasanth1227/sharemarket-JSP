package Model;



public class User {
	private int userId;
	private String userPassword;
	private String userBankAccount;
	private String userAdharCard;
	private String userPanCard;
	private String userName;
	private double balance;

	
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


	public User(int userId, String userPassword, String userBankAccount, String userAdharCard, String userPanCard,
			String userName) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userBankAccount = userBankAccount;
		this.userAdharCard = userAdharCard;
		this.userPanCard = userPanCard;
		this.balance = 0.0;
		this.userName = userName;
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
