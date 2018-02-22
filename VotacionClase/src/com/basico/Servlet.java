package com.basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url=("jdbc:mysql://localhost:3306/votacion");
    String user=("root");
    String password=("");  
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String equi=request.getParameter("equipo");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,password);
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT SUM(media) AS media, equipo FROM votaciones GROUP BY equipo");
			out.println("<table border=\"1\">");
			out.println("<tr>");
			 out.println("<td>" + "Equipo" + "</td>");
			 out.println("<td>" + "Suma Media" + "</td>");
			 out.println("</tr>");
			 while(resultSet.next()) {
				 
				 out.println("<tr>");
				 out.println("<td>" + resultSet.getString("equipo") + "</td>");
				
				 out.println("<td>" + resultSet.getInt("media") + "</td>");
				 out.println("</tr>");
			
			 ;}
			 out.println("</table>");
		 } catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 } catch (SQLException e){
			 e.printStackTrace();


}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		int pres = Integer.parseInt(request.getParameter("presentacion"));
		int segu = Integer.parseInt(request.getParameter("seguridad"));
		int dise = Integer.parseInt(request.getParameter("diseño"));
		int acce = Integer.parseInt(request.getParameter("accesibilidad"));
		int func =Integer.parseInt(request.getParameter("funcionalidad"));
		int media= (pres+segu+dise+acce+func)/5;
		 String equi=request.getParameter("equipo");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection(url,user,password);
				
				PreparedStatement ps= connect.prepareStatement("insert into votaciones(presentacion, seguridad,diseño, accesibilidad,funcionalidad,media,equipo) values(?,?,?,?,?,?,?)");
			
				ps.setInt(1, pres);
				ps.setInt(2, segu);
				ps.setInt(3, dise);
				ps.setInt(4, acce);
				ps.setInt(5, func);
				ps.setInt(6, media);
				ps.setString(7,equi);
				ps.executeUpdate();
				
				System.out.println("Entrada Insertada Correctamente");
				
				response.sendRedirect("/VotacionClase");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
