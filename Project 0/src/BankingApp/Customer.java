package BankingApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.HashMap;

public class Customer extends UserAccount {
	
	AccountActivity eq = new AccountActivity();
	UserAccount acc = new UserAccount();
	
	
	public void accountEntry(UserAccount account) {
		Map<Integer,UserAccount> map = new HashMap<>();
		int num = 1;
		acc =account;
		map.put(num, acc);
		for(Map.Entry m:map.entrySet())
		{
			//getKey() finds the integer key and getValue() retrieves the value
			//Ask Mayur if this is okay to execute
			map.put(num, (UserAccount) m.getValue());
			num++;
		}
		
	}
	//for transferring money
	public void accountTransfer(int num, double money) {
		HashMap<Integer,Double> m = new HashMap<>();
		acc.amount =money;
		m.put(num, acc.amount);
	}
	
	//last priority
	public void jointAccounts() {
		//access by two people
	}
	
	
	
	public void customerRegSerial(String user, String pass, double intialMoney) {
		//account information
		acc.userName = user;
		acc.password = pass;
		acc.amount = intialMoney;
		//making comparison
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/serialization.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(acc);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}	
	}
	
	
	public void customerDepSerial(double money) {
		//account information
		acc.amount = eq.cusDeposit(money);
//		acc.userName = user;
//		acc.password = pass;
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/serialization.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(acc);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}	
	}
	
	
	
	
	public void customerWithSerial(double money) {
		//account information
		acc.amount = money + acc.amount;
//		acc.userName = user;
//		acc.password = pass;
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/serialization.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(acc);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}	
	}
	

}
