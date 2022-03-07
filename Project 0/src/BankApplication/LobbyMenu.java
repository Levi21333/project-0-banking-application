package BankApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class LobbyMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int decision;
		String namelog;
		String pwlog;
		String regname;
		String regpw;
		double money;
		boolean approve;
		int pin;
		String code;
		
		Customers cus = new Customers();
		Employee e = new Employee();
		SerializeDeserialize deserial = new SerializeDeserialize();
		


		do {
			//try catch
			System.out.println(" Type 1 for Register or 2 for Login?");
			decision = input.nextInt();
		}while(decision != 1 && decision != 2);
		switch(decision) {
		case 1:
			do {
				//put this in a try an catch for error
				System.out.println("Type 1 for Customer, 2 for Employee, or 3 for Administer");
				decision = input.nextInt();
			}while(decision != 1 && decision !=2 && decision !=3);
			switch(decision) {
				case 1:
					System.out.println("Choose your username: ");
					 regname= input.next();
					System.out.println("Choose your password: ");
					regpw= input.next();
					System.out.println("Enter initial deposit: ");
					money = input.nextDouble();
					//Serialize information here
					Customers.customerList(regname, regpw,money);
					break;
				case 2:
					System.out.println("Choose your A username: ");
					regname = input.next();
					System.out.println("Choose your A password: ");
					regpw = input.next();
					System.out.println("Make a pin number");
					pin = input.nextInt();
					Employee.employeeList(regname,regpw, pin);
					break;
				case 3:
					System.out.println("Choose your M username: ");
					regname = input.next();
					System.out.println("Choose your M password: ");
					regpw = input.next();
					System.out.println("Give a memory Code: ");
					code = input.next();
					Administrator.administorList(regname, regpw, code);
					break;
			//serialize the information here
			//Nested
			}
			break;
		case 2:
			//if you are a customer, admin, or employee manager
			SerializeDeserialize.deserialCustomers();
			SerializeDeserialize.deserialEmployee();
			SerializeDeserialize.deserialAdmin();
			do {
				//put this in a try an catch for error
				System.out.println("Type 1 for Customer, 2 for Employee, or 3 for Administer");
				decision = input.nextInt();
			}while(decision != 1 && decision !=2 && decision !=3);
			switch(decision) {
				case 1: //Customer entry
					System.out.println("Give your C username: ");
					namelog = input.next();
					System.out.println("Give your C password: ");
					pwlog = input.next();
					System.out.println("Check for approval");
					System.out.println("Give 1 for employee or 2 for employee's admin: ");
					decision = input.nextInt();
					switch(decision) {
						case 1:
							//case 1 is Employee
							System.out.println("Give Employee's user");
							String empName = input.next();
							System.out.println("Give your password: ");
							String empPass = input.next();
							System.out.println("Enter pin Number: ");
							pin = input.nextInt();
							boolean ent = Employee.checkTheAccount(empName, empPass, pin);
							if(ent==true) {
								System.out.println("Approve Customer: yes or no");
								String valid = input.next();
								boolean approve1 = Employee.accApproval(valid);
								approve = Customers.checkTheAccount(namelog, pwlog);
								if(approve == true && approve1==true) { //stop here start
									System.out.println("Do you want to make a deposit(please type 1), withdraw (please type 2), or transfer(please type 3)?");
									decision = input.nextInt();
									//continue here
									//switch statement
									switch(decision) {
										case 1:
											//Deposit
											System.out.println("Please enter the amount you care to place");
											money = input.nextDouble();
											Customers.newDeposit(namelog,money); //change
											break;
											
										case 2:
											//Withdraws
											System.out.println("Please enter the amount you care to place");
											money = input.nextDouble();
											Customers.newWithdraw(namelog,money); //change
											break;
										case 3:
											//transfers
											System.out.println("Enter Username of account to transfer:");
											String other = input.next();
											System.out.println("Enter the amount to deposit in their account");
											money = input.nextDouble();
											Customers.accTransfer(namelog,other, money);
											break;
										default:
											System.out.println("Invalid entry");
									
									}//end
								}else {
									System.out.println("No access to account");
								}                                    //stop end
							}else {
								System.out.println("No access");
							}
							break;
							//case 1 end
						case 2:
							//case 2 is Admin
							System.out.println("Give Administrator's username");
							String adName = input.next();
							System.out.println("Give your password: ");
								String adPass = input.next();
							System.out.println("Enter Code word: ");
							code = input.next();
							boolean see = Administrator.checkTheAccount(adName, adPass, code);
							if (see==true) {
								System.out.println("Approve Customer: yes or no");
								String valid = input.next();
								boolean approve2 = Employee.accApproval(valid);
								approve = Customers.checkTheAccount(namelog, pwlog);
								if (approve==true&&approve2==true) {
									System.out.println("Do you want to make a deposit(please type 1), withdraw (please type 2), or transfer(please type 3)?");
									decision = input.nextInt();
									//continue here
									//switch statement
									switch(decision) {
										case 1:
											//Deposit
											System.out.println("Please enter the amount you care to place");
											money = input.nextDouble();
											Customers.newDeposit(namelog,money); //change
											break;
										case 2:
											//Withdraw
											System.out.println("Please enter the amount you care to place");
											money = input.nextDouble();
											Customers.newWithdraw(namelog,money); //change
											break;
										case 3:
											//Transfer
											System.out.println("Enter Username of account to transfer:");
											String other = input.next();
											System.out.println("Enter the amount to deposit in their account");
											money = input.nextDouble();
											Customers.accTransfer(namelog,other, money);
											break;
										default:
											System.out.println("Invalid Entry");
									
									}//end
								}else {
									System.out.println("No access to account");
								}
								
							}else {
								System.out.println("No access");
							}
							break;
							//case 2 end
						default:
							System.out.println("Invalid entry");
					}// case 1: Customer switch statement ends
					break;
					
					
				case 2: //Employee entry
					System.out.println("Give your username: ");
					namelog = input.next();
					System.out.println("Give your password: ");
					pwlog = input.next();
					System.out.println("Enter pin Number: ");
					pin = input.nextInt();
					approve = Employee.checkTheAccount(namelog, pwlog, pin);
					if(approve==true) {
						System.out.println("Select Customer's username to view their account information: ");
						String nameCus = input.next();
						Employee.accountInformation(nameCus);
					}else {
						System.out.println("No access to the account.");
					}
					//Access entry number
					break;
				case 3: //Admin entry
					System.out.println("Give your A username: ");
					namelog = input.next();
					System.out.println("Give your A password: ");
					pwlog = input.next();
					System.out.println("Enter your memory code: ");
					code = input.next();
					approve = Administrator.checkTheAccount(namelog, pwlog, code);
					if(approve==true) {
						System.out.println("Select Activity: 1---Deposit,2---Withdraw,3---Transfer, 4---View Account,5----Cancel Account");
						decision = input.nextInt();
						switch(decision) {
							case 1:
								System.out.println("Enter Account Name for Deposit:");
								String nameCus1=input.next();
								System.out.println("Enter amount for deposit:");
								money = input.nextDouble();
								Administrator.newDeposit(nameCus1, money);
								break;
							case 2:
								System.out.println("Enter Account Name to withdraw from:");
								String nameCus2=input.next();
								System.out.println("Enter amount to withdraw:");
								money = input.nextDouble();
								Administrator.newWithdraw(nameCus2, money);
								break;
							case 3:
								System.out.println("Enter First Account Name to transfer from:");
								String nameCus3=input.next();
								System.out.println("Enter First Account Name to transfer to:");
								String nameCus4=input.next();
								System.out.println("Enter amount:");
								money = input.nextDouble();
								Administrator.accTransfer(nameCus3,nameCus4,money);
								break;
							case 4:
								System.out.println("Enter First Account Name for viewing:");
								String nameCus5=input.next();
								Administrator.accountInformation(nameCus5);
								break;
							case 5:
								System.out.println("Enter the Account that should be removed:");
								String nameCus6 = input.next();
								Administrator.cancelAccount(nameCus6);
								break;
							default:
								System.out.println("Inappropriate entry");
						}
					}else {
						System.out.println("No access to account");
					}
					//Access entry number
					break;
				default:
					System.out.println("Not Valid Choose");
			}
			//Nested decision making
			//This should be where to determine admin, customer, or admin
			//serialization
			//de-serialization
			break;
		default:
			System.out.println("Not Valid Choose");
		}

	}

}
