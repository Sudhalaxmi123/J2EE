//deleting a data in table 

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class demo3 {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded succefully");
		
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jun_2024", "root", "root");
		System.out.println("Connection established");
		
		String s = "delete from student where id=?";
		PreparedStatement pstmt= con.prepareStatement(s);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to be deleted");
	    int id = sc.nextInt();
	    
	    pstmt.setInt(1, id);
	    int rows=pstmt.executeUpdate();
	    System.out.println(rows);

	}

}
