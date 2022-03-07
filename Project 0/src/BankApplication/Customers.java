package BankApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Customers implements java.io.Serializable{
	public double amount;
	public String accInfo;
	public long accountNum;
	public long routNum;
	public String userName;
	public String password;
	public String firstName;
	public String lastName;
//	public int userType;
	
	

	static HashMap<String,Customers> map = new HashMap<String,Customers>();
	
	
	//serialized method in here
	
	public Customers() {

		
	}
	
	public Customers(String name,String pass, double money) {
		this.userName=name;
		this.password=pass;
		this.amount=money;
		
	}
	
	public static void customerList(String name, String pass, double money) {
		Customers draw = new Customers(name,pass,money);
		map.put(name, draw);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/CusTest.ser"); //CusTest.ser
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(map);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	

	
	//checks login information to see if proper information entered inside---------------------------
//	public static boolean compNameWord(String login, String reg) {
//		if(!login.equals(reg)){
//			return false;
//		}
//		else {
//			return true;
//		}
//	}
	
	public static boolean checkTheAccount(String userName, String word) {
//		boolean acc1= compNameWord(name, e.userName);
//		boolean acc2 = compNameWord(word,e.password);
		if (map.containsKey(userName)) {
			if(map.get(userName).password.equals(word)) {
			return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;	
		}
	}
	
	//Transaction part of the program-----------------------------------------------------------
	public static double newBalance(String name, double money) {
		map.get(name).amount= money;
		try {
			
			FileOutputStream fileOut = new FileOutputStream("./src/CusTest.ser"); //CusTest.ser
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(map);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		money = map.get(name).amount;
		return money;
	}
	//Deposits money
	public static void newDeposit(String name,double deposit) {
		double newBal=AccountActivity.moneyEntry(map.get(name).amount, deposit);
		map.get(name).amount= newBalance(name,newBal); //change this from SerialDeserial
		System.out.println("Showing your balance: $"+String.format("%2f",map.get(name).amount));
	}
	//Withdraw money
	public static void newWithdraw(String name, double withdraw) {
		double newBal=AccountActivity.cusWithdraw(map.get(name).amount, withdraw);
		map.get(name).amount=newBalance(name,newBal);
		System.out.println("Showing your balance: $"+String.format("%2f",map.get(name).amount));
	}
	//Transfers money
	public static void accTransfer(String name1,String name2, double money) {
		double newBal1=AccountActivity.cusWithdraw(map.get(name1).amount, money);
		map.get(name1).amount=newBalance(name1,newBal1);
		
		double newBal2=AccountActivity.moneyEntry(map.get(name2).amount, money);
		map.get(name2).amount=newBalance(name2,newBal2);
		System.out.println("Showing balance of "+map.get(name1).userName +": $"+String.format("%2f",map.get(name1).amount));
		System.out.println("Showing your balance"+map.get(name2).userName+": $"+String.format("%2f",map.get(name2).amount));
	}
	
	//Last make a joint
	
	
	


}
