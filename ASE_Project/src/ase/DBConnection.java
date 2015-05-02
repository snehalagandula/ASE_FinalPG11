package ase;
import java.sql.*;

public class DBConnection {


	   public static void main(String[] args) {
		   
		   
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
			 Statement stmt = conn.createStatement();
			 String sql;
		      sql = "SELECT * from vacancy";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		    	  System.out.println(rs.getString(1));
		      System.out.println("Welcome");
		      }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
		   
		   
		   
		   
	   }
}
