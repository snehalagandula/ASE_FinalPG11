package ase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		String fname =(String) request.getParameter("name");
		String lname =(String) request.getParameter("code");
		String phonenum =(String) request.getParameter("PhoneNumber");
		String address =(String) request.getParameter("address");
		 
try
		
		{
	Class.forName("com.mysql.jdbc.Driver");
			//get a connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
			
			
			//create a statement
			
			Statement stmt= conn.createStatement();
			
			//execute query
		   
			int i=stmt.executeUpdate("insert into registration values('"+fname+"','"+lname+"','"+phonenum+"','"+address+"')");
			
			
			//process the result	
			if(i>0)
			{
                out.println("Inserted Successfully");
                RequestDispatcher rd=request.getRequestDispatcher("Success.html");
    			rd.forward(request, response);
			}
              else
              {
                out.println("Insert Unsuccessful");
              }
			
			
			
		}
		catch(Exception e)
				{
			e.printStackTrace();
				}
	}

}
