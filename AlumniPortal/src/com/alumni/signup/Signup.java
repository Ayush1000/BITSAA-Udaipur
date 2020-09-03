package com.alumni.signup;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.signup.model.SignupBean;
import com.alumni.signup.model.SignupDB;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");    
	    String lastname = request.getParameter("lastname");
	    String email = request.getParameter("email");    
	    String phonenumber = request.getParameter("phonenumber");
	    String password = request.getParameter("password");    
	    String gender = request.getParameter("gender");
	    //String username = request.getParameter("username");
	    
	    SignupBean user=new SignupBean();
	    
	    user.setFirstname(firstname);
	    user.setLastname(lastname);
	    user.setPhonenumber(phonenumber);
	    user.setEmail(email);
	    user.setPassword(password);
	    user.setGender(gender);
	    //user.setUsername(username);
	    
	    SignupDB reg=new SignupDB();
	    
	    int check = reg.getUser(email);
	    if(check==0)
	    {
	    reg.registration(user);
	    
	    int userid = reg.getUser(email);
	 
	    response.sendRedirect("registrationprofile.jsp?userid="+userid);
	    }
	    else
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("Signup.jsp");
	    	request.setAttribute("msg", "Email already exist");
	    	rd.forward(request,response);
	    	
	    }
	}

}
