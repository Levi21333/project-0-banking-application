package BankApplication;



public class AccountActivity {
	
	//Depositing
	public static double moneyEntry(double transaction, double money) {
		transaction +=money;
		return transaction;
	}
	
	public static void balanceAccount(double balance, double entry) throws AccountException {
		if (entry<0) {
			throw new AccountException("Cannot have a negative balance");
		}
		else if (balance<entry) {
			throw new AccountException("No sufficient fund to withdraw");	
		}
	}
	
	public static double cusWithdraw(double transaction, double money) {
		transaction -= money;
		try {
			balanceAccount(transaction,money);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transaction;
	}
	
	

}
