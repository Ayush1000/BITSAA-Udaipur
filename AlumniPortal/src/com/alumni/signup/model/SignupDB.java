package com.alumni.signup.model;
import java.sql.*;

import javax.sql.*;

	@SuppressWarnings("unused")
	public class SignupDB 
	{

	   Connection con=null;
	   String url;
	   ResultSet rs = null; 
	   Statement st=null;
	         
	   public void registration(SignupBean user)
	   {
	     
	      try
	      {
			
	         String url ="jdbc:mysql://localhost/alumni"; 

	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         try
	         {               
	            con = DriverManager.getConnection(url,"root","Rishika31");
	            System.out.println("CONNECTED");
	           st = con.createStatement();
	           String qry="INSERT INTO user (firstname,lastname,email,phonenumber,password,gender) VALUES ('" +user.getFirstname()+ "','" + user.getLastname() + "','" + user.getEmail()+ "','" + user.getPhonenumber() + "','" + user.getPassword()+"','" + user.getGender()+ "')";
	           System.out.println(qry);
	           st.executeUpdate(qry);
	        
	           
	         }
	         
	         catch (SQLException e)
	         {
	            e.printStackTrace();
	         }
	      }

	      catch(ClassNotFoundException e)
	      {
	         System.out.println(e);
	      }
	}
	   public int getUser(String email)
	   {
		   int userid = 0;
		   
		   try
		      {
				
		         String url ="jdbc:mysql://localhost/alumni"; 

		         Class.forName("com.mysql.cj.jdbc.Driver");
		         
		         try
		         {               
		            con = DriverManager.getConnection(url,"root","Rishika31");
		            System.out.println("CONNECTED");
		           st = con.createStatement();
		           String qry="select userid from user where email='"+email+"'";
		           System.out.println(qry);
		           rs = st.executeQuery(qry);
		           
		           while(rs.next())
		           {
		        	   userid = rs.getInt("userid");
		           }
		        
		           
		         }
		         
		         catch (SQLException e)
		         {
		            e.printStackTrace();
		         }
		      }

		      catch(ClassNotFoundException e)
		      {
		         System.out.println(e);
		      }
		   
		   return userid;
	   }
} 