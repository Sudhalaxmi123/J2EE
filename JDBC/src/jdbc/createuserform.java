package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class createuserform {
	public static void main(String[] args) throws Exception{
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("1, Register");
        System.out.println("2, Login");
        System.out.println("Enter your Choice");
        int choice = sc.nextInt();
		
        switch(choice) {
        case 1: register();
        break;
         
        case 2: login();
        break;
        
        default:System.out.println("Invalid choice");
        break;
        }
	}
		
		public static void register() throws Exception{
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver is loaded sucessfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jun_2024","root", "root");
		System.out.println("Connection is loaded sucessfully");
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String name =sc.next();
		System.out.println("Enter the username");
		String username =sc.next();
		
		while(true) {
		
		String s = "select* from users where username=?";
		PreparedStatement pstmt= con.prepareStatement(s);
		pstmt.setString(1, username);
		ResultSet res = pstmt.executeQuery();
		
		if(res.next()) {
			System.out.println("Username already exists. Please enter another username");
			username = sc.next();
		}
		else {
			break;
		}
		}
		String paswrd;
		String cpaswrd;
		do {
		 System.out.println("Enter the password");
		 paswrd =sc.next();
		
		 System.out.println("Enter the confirmpassword");
	     cpaswrd =sc.next();
		}while(!paswrd.equals(cpaswrd));
		
		System.out.println("Enter the email");
		String email =sc.next();
		
		String s1 = "insert into users value(?,?,?,?)";
		PreparedStatement pstmt1= con.prepareStatement(s1);
		
		pstmt1.setString(1, name);
		pstmt1.setString(2, username);
		pstmt1.setString(3, paswrd);
		pstmt1.setString(4, email);
		pstmt1.executeUpdate();
	}
		
		 static void login() throws Exception {
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jun_2024","root", "root");
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter the username");
			String username =sc.next();
			
			System.out.println("Enter the password");
			String paswrd =sc.next();
			
			String s = "select * from users where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				if(paswrd.equals(res.getString(3))) {
					System.out.println("Login successful");
				}
				else {
					System.out.println("Invalid password");
				}
			}
				else {
					System.out.println("Invalid username");
				}
			

			
			
			

			
		}

}
