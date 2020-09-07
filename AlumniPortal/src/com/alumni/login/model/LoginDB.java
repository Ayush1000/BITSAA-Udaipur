package com.alumni.login.model;
import java.sql.*;

	public class LoginDB 
	{
				Connection con=null;
				String url;
				ResultSet rs = null; 
				Statement st=null;
				int userid=0;
			   public int logincheck(LoginBean user)
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
				           String qry="select * from user where email='" + user.getEmail() + "' and password= '" + user.getPassword()+ "'";
				           System.out.println(qry);
				           rs=st.executeQuery(qry);
				           
				           while(rs.next())
				           {
				        	   userid=rs.getInt("userid");
				        	  
				           }
				           rs.close();
				           st.close();
				           con.close();
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