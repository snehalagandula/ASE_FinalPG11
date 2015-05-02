package ase;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//get a connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
			
			
			//create a statement
			
			Statement stmt= conn.createStatement();
			
			//execute query
			
			ResultSet rs=stmt.executeQuery("select * from adminlogin");
			
			//process the result
			
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				
			}
			
		}
		catch(Exception e)
				{
			e.printStackTrace();
				}
				}
	

	}


