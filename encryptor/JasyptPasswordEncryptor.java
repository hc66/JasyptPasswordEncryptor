package encryptor;

import java.io.Console;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptPasswordEncryptor {
	
	public static void main(String[] args) {
		
		Console console = null;

	      	try {
	    	  
	    		console = System.console();
	         
	         	if (console != null) {

	            		char[]  pwd = console.readPassword("Enter Password: ");
	            		char[]  pwd2 = console.readPassword("Enter Password Again: ");

	            		String pwdString = new String(pwd);
	            		String pwd2String = new String(pwd2);

	            		if (pwdString.equals(pwd2String)) {

					System.out.println("Congrats! Passwords match.");

					StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
					
					encryptor.setPassword("MyKey");
					
					String encrypt_password = encryptor.encrypt(pwdString);

	                		System.out.println("Encrpted Password is: "+ encrypt_password);

				} else {

					System.out.println("Passwords Do Not Match. Run the Program Again.");

			    	}

	        	}
	         
	      	} catch(Exception ex) {

	         	ex.printStackTrace();
	         
	      	}

	}
}
