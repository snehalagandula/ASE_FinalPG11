


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
 * Servlet implementation class HRegistration
 */

	

	
	@WebServlet("/HRegistration")
	public class HRegistration extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public HRegistration() {
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
		
			String firstname =(String) request.getParameter("firstname");
			String lastname =(String) request.getParameter("lastname");
			String email =(String) request.getParameter("email");
			String password =(String) request.getParameter("password");
			 
	try
			
			{
		Class.forName("com.mysql.jdbc.Driver");
				//get a connection
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
				
				
				//create a statement
				
				Statement stmt= conn.createStatement();
				
				//execute query
			   
				int i=stmt.executeUpdate("insert into hregistration values('"+firstname+"','"+lastname+"','"+email+"','"+password+"')");
				
				
				//process the result	
				if(i>0)
				{
	                out.println("Inserted Successfully");
	                RequestDispatcher rd=request.getRequestDispatcher("index.html");
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
