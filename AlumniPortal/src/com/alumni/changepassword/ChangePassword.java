package com.alumni.changepassword;
import java.io.IOException;
import java.sql.*;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.changepassword.model.ChangePasswordBean;
import com.alumni.changepassword.model.ChangePasswordDB;
//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	{
		// TODO Auto-generated method stub
		 
	        String url="jdbc:mysql://localhost/alumni";

	        String driver = "com.mysql.cj.jdbc.Driver";

	        String user = "root";

	        String pass = "Ranu31@dec";

	        HttpSession session=request.getSession();


	        String password=request.getParameter("password");

	        String newpassword=request.getParameter("password1");

	        String retypepassword=request.getParameter("password2");

	       // Message msg=null;
	        try

	        {    
	            Class.forName(driver);
	        
	        
	            Connection con=DriverManager.getConnection(url,user,pass);
	            System.out.println("Connected");
	            
	            
	                    
	        
	        if (newpassword.equals(retypepassword) )//|| retypepassword.equals(""))

	            {

	        	Statement st=con.createStatement();
                //ps.setString(1,newpassword);

               // ps.setString(2, username);

                //ps.setString(2, password);

                st.executeUpdate("update user set password='"+newpassword+"' where password='"+password+"'");
                

                RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	            rd.forward(request,response);

	                return;    

	                }

	                else if (!newpassword.equals(retypepassword))

	            {

	                	RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
	    	            rd.forward(request,response);

	                return;

	                }
	      
	             
	}
	        catch(Exception e)

	        {

	            e.printStackTrace();

	        }
		 finally
		 {
			 
		 }
	       }
}


	                  