package com.alumni.profileread;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alumni.profile.model.ProfileBean;
import com.alumni.profileread.model.ProfileRadDB;
import com.alumni.profileread.model.ProfileReadBean;

/**
 * Servlet implementation class Profileread
 */
@WebServlet("/ProfileRead")
public class ProfileRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		int userid = (int)session.getAttribute("userid");
		
		ProfileRadDB viewProf = new ProfileRadDB();
		ProfileReadBean user = viewProf.viewProfile(userid);
		request.setAttribute("user", user);
        
        String page = "/readprofile.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	

}
