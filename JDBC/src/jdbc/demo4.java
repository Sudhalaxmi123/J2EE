//Transaction is refers to the set of statements that have to be compulsary executed. 
//in transaction either everything should be executed or nothing should be executed.1
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class demo4 {

	public static void main(String[] args) throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jun_2024", "root", "root");
		
		Scanner sc = new Scanner(System.in);
		String s = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(s); 
	    con.setAutoCommit(false); //setAuto we can use each and every line execute without stop middle;
		System.out.println("Enter the id");
		int id =sc.nextInt();
		System.out.println("Enter the name");
		String name =sc.next();
		System.out.println("Enter the marks1");
		int marks1 =sc.nextInt();
		System.out.println("Enter the marks2");
		int marks2 =sc.nextInt();
		System.out.println("Enter the marks3");
		int marks3 =sc.nextInt();
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, marks1);
		pstmt.setInt(4, marks2);
		pstmt.setInt(5, marks3);
		int rows = pstmt.executeUpdate();
		
		String s1 = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(s); 
	
		System.out.println("Enter the id1");
		int id1 =sc.nextInt();
		System.out.println("Enter the name1");
		String name1 =sc.next();
		System.out.println("Enter the marks11");
		int marks11 =sc.nextInt();
		System.out.println("Enter the marks21");
		int marks21 =sc.nextInt();
		System.out.println("Enter the marks31");
		int marks31 =sc.nextInt();
		pstmt1.setInt(1, id1);
		pstmt1.setString(2, name1);
		pstmt1.setInt(3, marks11);
		pstmt1.setInt(4, marks21);
		pstmt1.setInt(5, marks31);
	    pstmt1.executeUpdate();

	    con.commit();//without con.commit output is not display in table. 
		

	}

}
