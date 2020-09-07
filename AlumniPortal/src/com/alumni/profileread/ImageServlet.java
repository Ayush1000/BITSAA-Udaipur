package com.alumni.profileread;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
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
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet
{


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println("image servlet id = "+userid);
		 try
	      {
			 	Connection con;
			 	String url;
			    ResultSet rs = null; 
			    Statement st=null;
			         
	      
			    url ="jdbc:mysql://localhost/alumni"; 

	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         try
	         {               
	            con = DriverManager.getConnection(url,"root","Ranu31@dec");
	            System.out.println("CONNECTED");
	            PreparedStatement ps = con.prepareStatement("select image from profile where userid = ?");
	            ps.setInt(1,userid);
	            System.out.println(ps);
//	            String str = "select image from profile where userid ="+userid;
//	            System.out.println(str);
	            rs=ps.executeQuery();
	            while(rs.next())
	            {
	            	Blob img = rs.getBlob(1);
	            	System.out.println(img);
	                byte[] imgData = img.getBytes(1,(int)img.length());
	                System.out.println(imgData);
	            	OutputStream output = response.getOutputStream();
	            	System.out.println(output);
	            	response.setContentType("image/png");
	            	output.write(imgData);
//	            	output.flush();
//	            	output.close();
	            }
	            rs.close();
	            st.close();
	         }catch (SQLException e)
	         {
		            e.printStackTrace();
		         }
		      }

		      catch(Exception e)
		      {
		         System.out.println(e);
		      }
	}

}
