package DatabaseLayer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.User;

public class userDetails{

	private static  Session session ;

	public static double getBalance(int id) {
		double balance = 0;
		User user = null;
		session = DBConnect.getSession();
		session.beginTransaction();
		user  = (User) session.get(User.class, id);
		balance = user.getBalance();
		session.close();
		return Math.round(balance*100.00)/100.0;
		
	}
	public static int  setBalance(int id, double balance) {
		User user = null;
		session = DBConnect.getSession();
		Transaction trans = session.beginTransaction();
		user  = (User) session.get(User.class, id);
		user.setBalance(balance);
		session.update(user);
		trans.commit();
		session.close();
		return 1;
		
	}
	public static int withdraw(int id ,double amt,  double balance) {
		User user = null;
		session = DBConnect.getSession();
		Transaction trans = session.beginTransaction();
		user  = (User) session.get(User.class, id);
		user.setBalance(balance - amt);
		session.update(user);
		trans.commit();
		session.close();
		return 1;
	}
	public static int deposit(int id ,double amt,  double balance) {
		User user = null;
		session = DBConnect.getSession();
		Transaction trans = session.beginTransaction();
		user  = (User) session.get(User.class, id);
		user.setBalance(balance + amt);
		session.update(user);
		trans.commit();
		session.close();
		return 1;
	}
	@SuppressWarnings("unchecked")
	public static List<User> getUsers(){
		List<User> users = null;
		session = DBConnect.getSession();
		 session.beginTransaction();
		Query q = session.createQuery("from User");
		users  = q.list();
		session.close();
		return users;
 	}
	public static User getUserById(int id) {
		User user = null;
		session = DBConnect.getSession();
		session.beginTransaction();
		user  = (User) session.get(User.class, id);
		
		session.close();
		return user;
	}
	public static boolean deleteUserById(int id) {
		User user = null;
		session = DBConnect.getSession();
		Transaction trans = session.beginTransaction();
		user  = (User) session.get(User.class, id);
		session.delete(user);
		trans.commit();
		session.close();
		return true;
	}
	public static int [] newUser( String userEmail , String userName , String userPassword,String userBankAccount,String userAdharCard,String userPanCard) {
		int id = getUsers().size();
		User user = null;
		session = DBConnect.getSession();
		Transaction trans =  session.beginTransaction();
		 
		user  = new User( id + 1 ,userEmail, userPassword, userBankAccount, userAdharCard, userPanCard, userName);
		
		session.save(user);
		trans.commit();
		session.close();
		
		int newid = getUsers().size();	
		return new int[] {newid,id};
	}
	
	
	
}
