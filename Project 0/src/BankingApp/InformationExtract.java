package BankingApp;

import java.io.FileOutputStream;

import java.io.FileInputStream;

public class InformationExtract extends AccountActivity {
	
	//Should this be private or public?
	//Input in account number,routing number, personal ID?
	public void personalInfo(boolean access,String info) {
		if(access==true){
			System.out.println(info);
		}
		else {
			//do while
			do {
				
			}while(access==false);
		}
	}
	

	public void accountInfoSerial(String use, String pass) {
		//account information
		
		
	}
	
	

}
