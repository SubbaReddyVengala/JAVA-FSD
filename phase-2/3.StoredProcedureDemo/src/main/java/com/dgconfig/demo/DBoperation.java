package com.dgconfig.demo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.cj.xdevapi.Statement;
@WebServlet("/dboperation")
public class DBoperation extends  HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
Properties props=new Properties();
		
		InputStream in= getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		Connection conn=DBConfig.getConnection(props);

		try {
			
			
			java.sql.Statement stmt=conn.createStatement();
			
			
			//SQL  query
			int  x= stmt.executeUpdate("create database demos1");
			
			if(x>0)
				out.print("Database Created Successfully<br>");
			else
				out.print("Database already exist<br>");
			
			//SQL  query
			stmt.execute("use demos1");
			
			out.print("Database is Selected<br>");
			
			//SQL  query
			stmt.execute("drop database demos1");
			
			out.print("Database Dropped Successfully<br>");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
