package Controller;




import DatabaseLayer.MySQLConnection;
import DatabaseLayer.userDetails;
public class userRegistrationController extends MySQLConnection  {

	public static int createUser(String userName ,String userAdharCard, String userPanCard,String userBankAccount,  String userPassword)  {
		    int id[] = userDetails.newUser(userName, userPassword, userBankAccount, userAdharCard, userPanCard);
			if(id[1]+1 == id[0]) {
				 return id[0];
			}
			return -1;
	}
	
}
