package com.alumni.forgotpassword3;


import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.forgotpassword3.model.ForgotPassword3Bean;

/**
 * Servlet implementation class Forgotpass3
 */
@WebServlet("/ForgotPassword3")
public class ForgotPassword3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String url="jdbc:mysql://localhost/alumni";

	        String driver = "com.mysql.cj.jdbc.Driver";

	        String user = "root";

	        String pass = "Rishika31";

	        HttpSession session = request.getSession(true);
	 	   String email=(String)session.getAttribute("email"); 

	        String newpassword=request.getParameter("password");

	        String retypepassword=request.getParameter("password1");

	       // Message msg=null;
	        try

	        {    
	            Class.forName(driver);
	        
	        
	            Connection con=DriverManager.getConnection(url,user,pass);
	            System.out.println("Connected");
	            
	            
	                    
	        
	        if (newpassword.equals(retypepassword) )//|| retypepassword.equals(""))

	            {

	        	Statement st=con.createStatement();
             st.executeUpdate("update user set password='"+newpassword+"' where email='"+email+"'");
             

             RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	            rd.forward(request,response);

	                return;    

	                }

	                else if (!newpassword.equals(retypepassword))

	            {

	                	RequestDispatcher rd=request.getRequestDispatcher("Forgotpass3.jsp");
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
