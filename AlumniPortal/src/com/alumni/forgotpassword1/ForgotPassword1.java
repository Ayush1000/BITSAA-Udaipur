package com.alumni.forgotpassword1;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class Forgotpass1
 */
@WebServlet("/ForgotPassword1")
public class ForgotPassword1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost/alumni";

        String driver = "com.mysql.cj.jdbc.Driver";

        String user = "root";

        String pass = "Ranu31@dec";

        HttpSession session=request.getSession();


       String email=request.getParameter("email");

        //String newpassword=request.getParameter("password1");

        //String retypepassword=request.getParameter("password2");

       // Message msg=null;
        try

        {    
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pass);
            System.out.println("Connected");
            ResultSet rs=null;
            String sql="select * from user where email= '"+ email +"'";
            PreparedStatement pst= con.prepareStatement(sql);
           // pst.setString(1, email);
            rs=pst.executeQuery(sql);
           // ForgotPassword1Bean user1=new ForgotPassword1Bean();
            if(rs.next()) {
                System.out.println("The email is valid");
                RequestDispatcher rd=request.getRequestDispatcher("Forgotpass3.jsp");
                rd.forward(request,response);
                session.setAttribute("email", email);
              }
              else {
            	  RequestDispatcher rd=request.getRequestDispatcher("Forgotpass1.jsp");
                  rd.forward(request,response);
                System.out.println("Email is not valid");
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
