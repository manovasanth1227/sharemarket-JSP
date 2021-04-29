package Controller;




import java.util.Scanner;

import DatabaseLayer.MySQLConnection;
import DatabaseLayer.userDetails;

public class userController extends MySQLConnection {

	public static void deposit(int id, Scanner s) {
		double balance=userDetails.getBalance(id);
		System.out.println("-------------------Deposit-------------------");
		System.out.println("Available Balance : " + Math.round(balance * 100D) / 100D);
		System.out.println("Enter Amount to be Deposited ->");
		double amt  = s.nextDouble();
		s.nextLine();
		userDepositController.deposit(amt,id,balance);
	}
	public static void withDraw(int id, Scanner s) {
		double balance=userDetails.getBalance(id);
		System.out.println("-------------------Deposit-------------------");
		System.out.println("Available Balance : " +Math.round(balance * 100D) / 100D);
		System.out.println("Enter Amount to Withdraw ->");
		double amt  = s.nextDouble();
		s.nextLine();
		if(amt < balance)userWithDrawController.withDraw(id, amt,balance);
		else {
			System.out.print("-------------------Over Draft-------------------");
		}
	}
	public static void viewBalance(int id, Scanner s) {
		double balance=userDetails.getBalance(id);
		System.out.println("-------------------View Balance-------------------");
		System.out.println("Available Balance : " + Math.round(balance * 100D) / 100D);
	}
}
