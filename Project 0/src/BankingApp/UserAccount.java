package BankingApp;

public class UserAccount implements java.io.Serializable{
	public double amount;
	public String accInfo;
	public long accountNum;
	public long routNum;
	public String userName;
	public String password;
	public int userType;
	
	public void accountTransaction() {
		//loop it later please
		System.out.println(accInfo+amount);
		
	}
	//Use this with for each account Mapped with their user name and pass word as keys
	public void personalInfo() {
		System.out.println("Username: "+userName);
		System.out.println("Password: "+password);
		System.out.println("Account Number: "+accountNum);
		System.out.println("Routing Number: "+routNum);
	}

}
