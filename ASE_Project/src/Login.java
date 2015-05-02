

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Jdbc
 */
/*@WebServlet("/Jdbc")*/
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String username =request.getParameter("name");
		String password =request.getParameter("password");
		String name,pass="";
		
		
try
		
		{
	Class.forName("com.mysql.jdbc.Driver");
			//get a connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
			
			
			//create a statement
			
			Statement stmt= conn.createStatement();
			
			//execute query
		   
			ResultSet rs=stmt.executeQuery("select password from login where username ='"+username+"'");
			Boolean isRecoredFound=false;
			
			//process the result	
			
			while(rs.next())
			{
				 isRecoredFound=true;
				pass=rs.getString("password");
				
			}
			try{
			conn.commit();
			}catch(Exception e){
				System.out.println("failed to commit connection");
			}
			if(!rs.isClosed()){
				try{
					rs.close();
				}catch(Exception e){
					
					System.out.println("failed to close result set");
				}
				
				
			}
			if(!stmt.isClosed()){
				try{
					stmt.close();
				}catch(Exception e){
					
					System.out.println("failed to close result set");
				}
				
				
			}
			if(!conn.isClosed()){
				try{
					conn.close();
				}catch(Exception e){
					
					System.out.println("failed to close result set");
				}
				
				
			}
			
			
			if(isRecoredFound){
				if(pass.equals(password)){
					RequestDispatcher rd=request.getRequestDispatcher("Success.html");
					rd.forward(request, response);	
					}else{
						
					
					RequestDispatcher rd=request.getRequestDispatcher("Failure.html");
					rd.forward(request, response);	
					}
				
				
				
			}else{
				
				RequestDispatcher rd=request.getRequestDispatcher("Failure.html");
				rd.forward(request, response);
				
				
			}
			
			
			
		}
		catch(Exception e)
				{
			e.printStackTrace();
				}
				}

		
	}