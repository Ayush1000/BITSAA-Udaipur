package com.alumni.login;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.alumni.login.model.LoginDB;
import com.alumni.login.model.LoginBean;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
			String email = request.getParameter("email");
			//String username = request.getParameter("username");
		    String password = request.getParameter("password");		    
		   
		    LoginBean user=new LoginBean();
		    
		    HttpSession session = request.getSession(true);
		    
		    
		    user.setEmail(email);
		    //user.setUsername(username);
		    user.setPassword(password);
		    
		    
		    LoginDB reg=new LoginDB();
		    reg.logincheck(user);
		    int userid=reg.logincheck(user);
		    
		      if(userid!=0)
      	   {
		    	  session.setAttribute("userid", userid);
		    	  session.setAttribute("email", email);
		    	 	    	  
		    	  response.sendRedirect("Home.jsp");
      	   }
      	   else
      	   {
      		 response.sendRedirect("Login.jsp");
      	   }
		    
		    
	}
	
		
	}

