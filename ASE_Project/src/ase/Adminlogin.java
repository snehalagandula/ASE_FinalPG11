package ase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminlogin() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String username =request.getParameter("name");
		String password =request.getParameter("password");
		String pass="";
		
		
try
		
		{
	Class.forName("com.mysql.jdbc.Driver");
			//get a connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
			
			
			//create a statement
			
			Statement stmt= conn.createStatement();
			
			//execute query
		   
			ResultSet rs=stmt.executeQuery("select password from Admin_Login where username ='"+username+"'");
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
					RequestDispatcher rd=request.getRequestDispatcher("AdminPage.html");
					rd.forward(request, response);	
					}else{
						
					
					RequestDispatcher rd=request.getRequestDispatcher("StudentFailure.html");
					rd.forward(request, response);	
					}
				
				
				
			}else{
				
				RequestDispatcher rd=request.getRequestDispatcher("StudentFailure.html");
				rd.forward(request, response);
				
				
			}
			
			
			
		}
		catch(Exception e)
				{
			e.printStackTrace();
				}
				

		
		
	}

}
