package ase;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Registration
 */
@WebServlet("/Nearest")
public class Nearest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Nearest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String lat1 = (String) request.getParameter("lat");
		String lon1 = (String) request.getParameter("lon");

		try

		{
			Class.forName("com.mysql.jdbc.Driver");
			// get a connection
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "admin");

			// create a statement

			Statement stmt = conn.createStatement();

			// execute query

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM NearestLocationSearch S ORDER BY ABS(ABS(S.`lat`-53.63) + ABS(S.`lon`-9.9)) ASC LIMIT 2;");

			// process the result
			while (rs.next()) {
				System.out.println("Success");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
