/*Updating a Data in Table */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class demo2 {
	public static void main(String[] args) throws Exception {
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	System.out.println("Driver loaded succefully");
	
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jun_2024", "root", "root");
	System.out.println("Connection established");
	
	String s = "update student set name=? where id=?";
	PreparedStatement pstmt= con.prepareStatement(s);
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Name");
	String name = sc.next();
	System.out.println("Enter the id");
	int id = sc.nextInt();
	pstmt.setString(1, name);
	pstmt.setInt(2, id);
	int rows=pstmt.executeUpdate();
	System.out.println(rows);
	
    
}
}
