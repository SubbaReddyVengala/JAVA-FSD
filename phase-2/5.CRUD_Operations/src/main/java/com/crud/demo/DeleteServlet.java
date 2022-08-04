package com.crud.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

//import com.dgconfig.demo.DBConfig;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		Properties props=new Properties();
				String param=req.getParameter("id");
				int id=Integer.parseInt(param);
				InputStream in= getServletContext().getResourceAsStream("/WEB-INF/application.properties");
				props.load(in);
				Connection conn=DBConfig.getConnection(props);
				if(conn!=null)
				{
			try {
				PreparedStatement stmt=conn.prepareStatement("delete from eproduct where id=?");
				stmt.setInt(1,id);
				int rs=stmt.executeUpdate();
				if(rs>0)
				{
				out.println(rs+ "deleted Succesfully from the database");
				resp.sendRedirect("list");
				}
				else
					out.println("failed to  delete the data");	
				
			} catch (Exception e) {
				// TODO: handle exception
			}
				}
				else
				{
					out.print("Error While Connecting the database");
				}
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
