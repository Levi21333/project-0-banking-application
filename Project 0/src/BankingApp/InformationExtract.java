package BankingApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InformationExtract extends AccountActivity {
	
	private static final boolean access1 = false;
	//Should this be private or public?
	//Input in account number,routing number, personal ID?
	private static final boolean access2 = false;
	
	//put this under
	public String seeUserInfo(String user, String namec) {
		AccountActivity a = new AccountActivity();
		String error = "Not Applicable";
		boolean check = a.compNameWord(user, namec);
		if (check==true) {
			return error;
		}
		else {
			return user;
		}
	}
	public String seeWordInfo(String pass, String pwc) {
		AccountActivity a = new AccountActivity();
		String error = "Not Applicable";
		boolean check = a.compNameWord(pass, pwc);
		if (check==true) {
			return error;
		}
		else {
			return pass;
		}
	}
	
	//When return true from seeInfo(), employee or admin can make a statement
	public String manageAccess(boolean check, String info) {
		if(check==true) {
			System.out.println(info);
		}
		else {
			System.out.println("Access denied");
		}
		
		return info;
	}
	
	// returns a String an only requires user and pass
//	public String Access(boolean case){
//		InformationExtract i = new InformationExtract();
//		info = i.seeInfo(case);
//		return info;
//	}

	// for admin and employees to see

	

	

	
	
	
	//For Customers to fill in their account money
	AccountActivity eq = new AccountActivity();
	UserAccount acc = new UserAccount();
	public void accountInfoSerial(String user, String pass, double money) {
		//account information
		acc.amount = eq.cusDeposit(money);
		acc.userName = user;
		acc.password = pass;
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
	//For registration
	public void accountRegSerial(String user, String pass) {
		//account information
		acc.userName = user;
		acc.password = pass;
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
	
	public void accountInfoDeserial() {
		UserAccount acc = null;
		try {
			FileInputStream fileIn = new FileInputStream("./src/serialization.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			acc = (UserAccount) in.readObject();
			System.out.println("Account Information: ");
			System.out.println(acc.accInfo+" "+acc.amount);
			System.out.println("Account Number: "+acc.accountNum);
			in.close();
			fileIn.close();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		} 
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void accountDeserial() {
		UserAccount acc = null;
		try {
			FileInputStream fileIn = new FileInputStream("./src/serialization.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			acc = (UserAccount) in.readObject();
			System.out.println("Account Information: ");
			System.out.println(acc.userName +" "+acc.password);
			System.out.println("Account balance: "+acc.amount);
			in.close();
			fileIn.close();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		} 
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void accountBalance() {
		UserAccount acc = null;
		try {
			FileInputStream fileIn = new FileInputStream("./src/serialization.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			acc = (UserAccount) in.readObject();
			acc.amount = eq.cusDeposit(acc.amount);
			System.out.println("New Balance is: "+acc.amount);
			in.close();
			fileIn.close();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		} 
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	//create more serialize and deserialize for employee and admin
	public void accountCheck(String user, String pass) {
		UserAccount acc = null;
//		boolean appr1;
//		boolean appr2;
//		AccountActivity check = new AccountActivity();
		try {
			FileInputStream fileIn = new FileInputStream("./src/serialization.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			acc = (UserAccount) in.readObject();
			AccountActivity check = new AccountActivity();
//			String takeUser = acc.userName;
//			String takePass = acc.password;
			boolean appr1 = check.compNameWord(user, acc.userName);
			boolean appr2 = check.compNameWord(pass, acc.password);
			if(appr1 ==true && appr2==true) {
				System.out.println("Access Approved");
			}
			else {
				System.out.println("You have enter the wrong requirments.");
			}
			in.close();
			fileIn.close();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		} 
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		access1 = check.compNameWord(user, acc.userName);
//		access2 = check.compNameWord(password, acc.password);

	}

}
