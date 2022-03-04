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
	
	public double cusDeposit(double money) {
		double transaction = 0;
		transaction += money;
		return transaction;
	}
	
	public void cusDepos(double money) {
		double transaction = 0;
		transaction += money;
		System.out.println("Your balance is: $"+transaction);
		
	}
	
	public double cusWithdraw(double money) {
		double transaction = 0;
		transaction -= money;
		try {
			balanceAccount(transaction,money);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transaction;
	}
	
	//deposits for employees customers go without info
	public String posTransaction(String info, double money) {
//		double transaction = 0;
//		transaction += money;
		String statement = info+money;
		//System.out.println(info+transaction);
		return statement;
	}
	
	
	
	public void userPassCheck(String user, String pass) {
		AccountActivity check = new AccountActivity();
//		InformationExtract form = new InformationExtract();
		UserAccount reg = new UserAccount();
		String takeUser = reg.userName;
		String takePass = reg.password;
		boolean access1 = check.compNameWord(user, takeUser);
		boolean access2 = check.compNameWord(pass, takePass);
//		info = form.manageAccess(access2, info);
		if(access1==true && access2 ==true){
			System.out.println("Access Approved");
		}
		else {
			//do while
			do {
				try {
					access1 = false;
					access2 = false;
				}
				catch(Exception e) {
					System.out.println("You have enter the wrong requirments. Please enter again:");
				}
			}while(access1==false && access2==false);
		}
	}
	//withdraws or payments
//	public String negTransaction(String info, double money) {
//		double transaction = 0;
//		transaction -= money;
//		try {
//			balanceAccount(transaction,money);
//		} catch (AccountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String statement = info+transaction;
//		//System.out.println(info+transaction);
//		return statement;
//	}

}
