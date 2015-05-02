package ase;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("application/json");
		//PrintWriter out = response.getWriter();
		
		//out.write("{ \"val1\" : \"5310 Rockhill Rd, 64110\", \"val2\" : \"Plaza,Kansas City \", \"val3\" : \"plaza\" }");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    
		String apt =(String) request.getParameter("dropdown");
		String vacancies =(String) request.getParameter("address");
		String zip =(String) request.getParameter("code");
		ArrayList<String> datalist = new ArrayList<String>();
		
		
		 
try
		
		{
	Class.forName("com.mysql.jdbc.Driver");
			//get a connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
			
			
			//create a statement
			
			
			
			//execute query
		   
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement("select * from vacancy where apt='"+apt+"'");
			
			
			//process the result	
			// ps.setString(1,name);                   
             out.print("<table width=50% border=1>");
             out.print("<h1>Vacancies Available:</h1>");
             out.print("<center>");
			ResultSet rs=ps.executeQuery();                
             /* Printing column names */
             ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
             
         
         while(rs.next())
                {
            

             out.print("<tr>");
             out.print("<td>"+rsmd.getColumnName(1)+"</td>");
                out.print("<td>"+rs.getString(1)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                out.print("<td>"+rs.getString(2)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
                out.print("<td>"+rs.getString(3)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
                out.print("<td>"+rs.getString(4)+"</td></tr>");
                out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
                out.print("<td>"+rs.getString(5)+"</td></tr>"); 
                out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
                out.print("<td>"+rs.getString(6)+"</td></tr>"); 
                
             }
             out.print("</center>");
             out.print("</table>");
			
            /* Object data =rs;
             request.setAttribute("data", data);
             request.getRequestDispatcher("./Search.html").forward(request, response);
             String destination = "./Success.html";
             
             RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
             rd.forward(request, response);
             response.sendRedirect("map.html");*/
			
			
		}
		catch(Exception e)
				{
			e.printStackTrace();
				
	}
//response.sendRedirect("Success.html");

	}

}
