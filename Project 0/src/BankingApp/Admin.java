package BankingApp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends UserAccount {
	
	AccountActivity eq = new AccountActivity();
	UserAccount acc = new UserAccount();
	
	public boolean adminApproval(int num,UserAccount user, boolean approve) {
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
	
	//making transactions
	public void transactionAcc(String statement,double money, int choice) {
		//account information
				Scanner input = new Scanner(System.in);
				System.out.println("Give statement here: ");
				statement = input.next();
				acc.accInfo =statement;
				System.out.println("Give statement here: ");
				money = input.nextDouble();
//				System.out.println("Type 1 for Deposit or Type 2 for Withdraw:");
//				choice =input.nextInt();
				if(choice == 1) {
					acc.amount = eq.cusDeposit(money);
					statement = eq.posTransaction(statement,acc.amount);
				}
				else if (choice == 2) {
					acc.amount = eq.cusWithdraw(money);
					statement = eq.posTransaction(statement,acc.amount);
				}
				acc.accInfo =statement;
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
	
	//canceling account
	public void accountCancel(int num, UserAccount user) {
		Map<Integer,UserAccount> map = new HashMap<>();
		map.remove(num,user);
	}

}
