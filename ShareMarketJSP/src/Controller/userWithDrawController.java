package Controller;



import DatabaseLayer.MySQLConnection;
import DatabaseLayer.userDetails;


public class userWithDrawController extends MySQLConnection {

		public static void withDraw(int id ,double amt,  double balance) {
			int res = userDetails.withdraw(id, amt, balance);
			if(res==1) {
				System.out.println("===================Withdraw Successfull===================");
			}else {
				System.out.println("===================Withdraw Unsuccessfull===================");
			}
				
		}
}
