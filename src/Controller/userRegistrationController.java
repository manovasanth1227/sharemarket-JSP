package Controller;





import DatabaseLayer.userDetails;
public class userRegistrationController  {

	public static int createUser(String userEmail , String userName ,String userAdharCard, String userPanCard,String userBankAccount,  String userPassword)  {
		    int id[] = userDetails.newUser(userEmail , userName, userPassword, userBankAccount, userAdharCard, userPanCard);
			if(id[1]+1 == id[0]) {
				 return id[0];
			}
			return -1;
	}
	
}
