package BankingApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class EmpManager extends UserAccount {
	
	AccountActivity eq = new AccountActivity();
	UserAccount acc = new UserAccount();
	
	//Ask Mayur if this is an appropriate logic
	public boolean manageApproval(int num,UserAccount user, boolean approve) {
		Map<Integer,UserAccount> map = new HashMap<>();
		acc = user;
		if (approve == true) {
			map.put(num, user);
			return true;
		}
		else {
			return false;
		}
	}
	//For Manager or Employee to see each account
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

}
