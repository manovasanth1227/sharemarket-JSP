package BussinessLogic;


import DatabaseLayer.userDetails;
import Model.User;


public class userAuthentication  {

	public static  boolean validateCredentials(int id , String userName, String password) {
		User user  = userDetails.getUserById(id);
			if(user!=null) {
				if(user.getUserEmail().equals(userName) && user.getUserPassword().equals(password)) {
					return true;
				}
			}
			return false;
		}
}
