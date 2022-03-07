package BankApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Administrator extends Employee implements java.io.Serializable {
	
	public String userName;
	public String password;
	public String codeWord;
	
	static HashMap<String,Administrator> admin = new HashMap<String,Administrator>();
	
	public Administrator() {
		
	}
	
	public Administrator(String name,String pass,String word) {
		this.userName=name;
		this.password=pass;
		this.codeWord=word;	
	}
	
	public static void administorList(String name, String pass, String code) {
		Administrator draw = new Administrator(name,pass,code);
		admin.put(name, draw);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/AdminTest.ser"); //AdminTest.ser
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(admin);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static boolean checkTheAccount(String userName, String word, String myCode) {
//		boolean acc1= compNameWord(name, e.userName);
//		boolean acc2 = compNameWord(word,e.password);
		if (admin.containsKey(userName)) {
			if(admin.get(userName).password.equals(word)) {
				if (admin.get(userName).codeWord.equals(myCode)) {
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
		else {
			return false;	
		}
	}
	
	
	//Admin can make transactions too
	public static void newDeposit(String name,double deposit) {
		double newBal=AccountActivity.moneyEntry(Customers.map.get(name).amount, deposit);
		Customers.map.get(name).amount= Customers.newBalance(name,newBal); //change this from SerialDeserial
		System.out.println("Showing your balance: $"+Customers.map.get(name).amount);
	}
	//Withdraw money
	public static void newWithdraw(String name, double withdraw) {
		double newBal=AccountActivity.cusWithdraw(Customers.map.get(name).amount, withdraw);
		Customers.map.get(name).amount=Customers.newBalance(name,newBal);
		System.out.println("Showing your balance: $"+Customers.map.get(name).amount);
	}
	//Transfers money
	public static void accTransfer(String name1,String name2, double money) {
		double newBal1=AccountActivity.cusWithdraw(Customers.map.get(name1).amount, money);
		Customers.map.get(name1).amount=Customers.newBalance(name1,newBal1);
		
		double newBal2=AccountActivity.moneyEntry(Customers.map.get(name2).amount, money);
		Customers.map.get(name2).amount=Customers.newBalance(name2,newBal2);
		System.out.println("Showing balance of "+Customers.map.get(name1).userName +": $"+Customers.map.get(name1).amount);
		System.out.println("Showing your balance"+Customers.map.get(name2).userName+": $"+Customers.map.get(name2).amount);
	}
	
	
	public static void accountInformation(String name) {
		System.out.println("Account Name: "+Customers.map.get(name).userName);
		System.out.println("Account password: "+Customers.map.get(name).password);
		System.out.println("Account Balance: "+Customers.map.get(name).amount);
		//Real First name
		//Real Last  name
	}
	
	
	//remove an account
	
	public static void cancelAccount(String name) {
		Customers.map.remove(name);
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/CusTest.ser"); //CusTest.ser
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Customers.map);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static boolean accApproval(String approve) {
		if(approve.equals("yes")) {
			
			return true;
		}
		else {
			return false;
		}

	}

}
