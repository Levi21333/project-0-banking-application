package BankingApp;

import java.util.*;

import java.util.Scanner;

public class LobbyPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		//change the parameters to integers and objects
//		HashMap<String,String> customer = new HashMap<>();
//		HashMap<String,String> employee = new HashMap<>();
//		HashMap<String,String> admin = new HashMap<>();
		
		
		
		//Condition Setting amongst customers, employees, and admins
		
		AccountActivity check = new AccountActivity();
		//comparing username from register to login
		//boolean acName = check.compNameWord(namelog, regname);
		//comparing password from register to login
		//boolean acPass = check.compNameWord(pwlog, regpw);
		
		
		int decision;
		String namelog;
		String pwlog;
		String regname;
		String regpw;
		double money;
		boolean approve;
		Customer account = new Customer();
		AccountActivity ck = new AccountActivity();
		InformationExtract access = new InformationExtract();

		do {
			//try catch
			System.out.println(" Type 1 for Register or 2 for Login?");
			decision = input.nextInt();
		}while(decision != 1 && decision != 2);
		switch(decision) {
		case 1:
			do {
				//put this in a try an catch for error
				System.out.println("Type 1 for Customer, 2 for Admin, or 3 for Manager");
				decision = input.nextInt();
			}while(decision != 1 && decision !=2 && decision !=3);
			switch(decision) {
				case 1:
					System.out.println("Choose your username: ");
					regname = input.next();
					System.out.println("Choose your password: ");
					regpw = input.next();
					System.out.println("Enter initial deposit: ");
					money = input.nextDouble();
					account.customerRegSerial(regname, regpw, money);
					break;
				case 2:
					System.out.println("Choose your A username: ");
					regname = input.next();
					System.out.println("Choose your A password: ");
					regpw = input.next();
					break;
				case 3:
					System.out.println("Choose your M username: ");
					regname = input.next();
					System.out.println("Choose your M password: ");
					regpw = input.next();
					break;
			//serialize the information here
			//Nested
			}
			break;
		case 2:
			//if you are a customer, admin, or employee manager
			do {
				//put this in a try an catch for error
				System.out.println("Type 1 for Customer, 2 for Admin, or 3 for Manager");
				decision = input.nextInt();
			}while(decision != 1 && decision !=2 && decision !=3);
			switch(decision) {
				case 1: //Customer entry
					System.out.println("Give your C username: ");
					namelog = input.next();
					System.out.println("Give your C password: ");
					pwlog = input.next();
//					approve password
					access.accountCheck(namelog,pwlog);
//					access.accountDeserial();
					approve = true;
					if (approve == true) {
						System.out.println("Do you want to make a deposit(please type 1) or withdraw (please type 2?");
						decision = input.nextInt();
						switch(decision) {
							case 1: //Deposit
								System.out.println("Please enter the amount you care to place");
								money = input.nextDouble();
								ck.cusDepos(money);
//								account.customerDepSerial(money);
//								access.accountBalance();
								break;
							case 2: //Withdraw
								System.out.println("Please enter the amount you care to place");
								money = input.nextDouble();
								account.customerWithSerial(money);
								access.accountBalance();
								break;
							default:
								System.out.println("Not Valid Choose");
						}
					}
					else {
						System.out.println("You have enter the wrong requirments.");
					}
					//deposit or withdraw from deserializing
					break;
				case 2: //Admin entry
					System.out.println("Give your A username: ");
					namelog = input.next();
					System.out.println("Give your A password: ");
					pwlog = input.next();
					//Access entry number
					break;
				case 3: //Manager entry
					System.out.println("Give your M username: ");
					namelog = input.next();
					System.out.println("Give your M password: ");
					pwlog = input.next();
					//Access entry number
					break;
				default:
					System.out.println("Not Valid Choose");
			}
			//Nested decision making
			//This should be where to determine admin, customer, or admin
			//serialization
			//de-serialization
			break;
		default:
			System.out.println("Not Valid Choose");
		}
		
	}

}
