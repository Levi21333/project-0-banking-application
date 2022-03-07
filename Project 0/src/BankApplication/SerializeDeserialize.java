package BankApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class SerializeDeserialize implements java.io.Serializable {
	
	public static void deserialCustomers() {
		Customers.map = null;
		try {
			
			FileInputStream fileIn = new FileInputStream("./src/CusTest.ser"); //CusTest.ser
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Customers.map = (HashMap) in.readObject();
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
	
	public static void deserialEmployee() {
		Employee.emp = null;
		try {
			
			FileInputStream fileIn = new FileInputStream("./src/EmpTest.ser"); //EmpTest.ser
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Employee.emp = (HashMap) in.readObject();
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
	
	public static void deserialAdmin() {
		Administrator.admin = null;
		try {
			
			FileInputStream fileIn = new FileInputStream("./src/AdminTest.ser");//AdminTest.ser
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Administrator.admin = (HashMap) in.readObject();
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
