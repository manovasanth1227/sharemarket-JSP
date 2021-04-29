package Controller;


import DatabaseLayer.MySQLConnection;
import DatabaseLayer.userDetails;


public class userDepositController extends MySQLConnection {

	public static void deposit(double amt, int id,double balance) {
		int res = userDetails.deposit(id, amt, balance);
		if(res==1) {
			System.out.println("===================Deposit Successfull===================");
		}else {
			System.out.println("===================Deposit Unsuccessfull===================");
		}
			
	}
}
