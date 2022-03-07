package BankApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;



public class Employee implements java.io.Serializable {
	
	public String userName;
	public String password;
	public int pin;
	
	
	static HashMap<String,Employee> emp = new HashMap<String,Employee>();
	
	public Employee() {
		
	}
	
	public Employee(String name,String pass,int num) {
		this.userName=name;
		this.password=pass;
		this.pin=num;
	}
	
	public static void employeeList(String name, String pass, int pin) {
		Employee draw = new Employee(name,pass,pin);
		emp.put(name, draw);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("./src/EmpTest.ser");//EmpTest.ser
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static boolean checkTheAccount(String userName, String word, int num) {
//		boolean acc1= compNameWord(name, e.userName);
//		boolean acc2 = compNameWord(word,e.password);
		if (emp.containsKey(userName)) {
			if(emp.get(userName).password.equals(word)) {
				if (num==emp.get(userName).pin) {
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
	
	//
	
	
	public static void accountInformation(String name) {
//		if(name.equals(Customers.map.get(name).userName)) {
		System.out.println("Account Name: "+Customers.map.get(name).userName);
		System.out.println("Account password: "+Customers.map.get(name).password);
		System.out.println("Account Balance: "+Customers.map.get(name).amount);
//		}else {
//			System.out.println("There is no one who matches this time");
//		}

	}
	
	//This will be the approve or don't approve
	//in the main, may be there could be a condition to be true and allow or false don't allow
	
	public static boolean accApproval(String approve) {
		if(approve.equals("yes")) {
			
			return true;
		}
		else {
			return false;
		}

	}
	
	
	

}
