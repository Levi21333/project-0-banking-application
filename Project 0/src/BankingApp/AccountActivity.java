package BankingApp;

public class AccountActivity {
	
	// username and password check
	
	public boolean compNameWord(String login, String reg) {
		if(!login.equals(reg)){
			return false;
		}
		else {
			return true;
		}
	}
	
	
	//this hands the transactions and other activities within the account
	
	public static void balanceAccount(double balance, double entry) throws AccountException {
		if (balance<0) {
			throw new AccountException("Cannot have a negative balance");
		}
		else if (balance<entry) {
			throw new AccountException("No sufficient fund to withdraw");	
		}
	}
	
	//deposits
	public String posTransaction(String info, double money) {
		double transaction = 0;
		transaction += money;
		String statement = info+transaction;
		//System.out.println(info+transaction);
		return statement;
	}
	//withdraws or payments
	public String negTransaction(String info, double money) {
		double transaction = 0;
		transaction -= money;
		try {
			balanceAccount(transaction,money);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String statement = info+transaction;
		//System.out.println(info+transaction);
		return statement;
	}

}
