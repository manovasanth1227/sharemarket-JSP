package Controller;



import BussinessLogic.userAuthentication;


public class userLoginController extends userAuthentication{

	public static boolean loginController(int id,String name,String password) {
				 
		
		if(userAuthentication.validateCredentials(id, name, password)) {
					 return true;
				}
		return false;
				 
					 
	}
				
}
