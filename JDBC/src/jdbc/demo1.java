/*Creating New Record(row) values in Existing table*/

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class demo1 {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded succefully");
		
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jun_2024", "root", "root");
		System.out.println("Connection established");
		
		String s = "insert into student values(?,?,?,?,?)"; //? it indicate placeholder
		PreparedStatement pstmt = con.prepareStatement(s); //when we create placeholder(?) we need to create PreparedStatement.
		Scanner sc = new Scanner(System.in);
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
		System.out.println(rows);
		
	}
}
