package com.alumni.changepassword.model;
import java.sql.*;


public class ChangePasswordDB {
		   static Connection con;
		   static String url;
		   static ResultSet rs = null; 
		   static Statement st=null;
		         
		   @SuppressWarnings("null")
		public void changepassword(ChangePasswordBean user,int userid) 

		   {
		     
		      try
		      {
		         String url ="jdbc:mysql://localhost/alumni"; 

		         Class.forName("com.mysql.cj.jdbc.Driver");
		         
		         try
		         {               
		            con = DriverManager.getConnection(url,"root","tiger"); 
		            st.executeQuery("select * from user where password='"+user.getCurrentPassword()+"'");
		            String currentPassword = null;
		            String newPassword=null;
					String retypePassword=null;
		            
					while(rs.next())
					{
		            userid=rs.getInt(1);
		            currentPassword=rs.getString(2);
		            }
		            System.out.println(userid+ " "+currentPassword);
		            if(currentPassword.equals(currentPassword))
		            {
		            	
						if(newPassword.equals(retypePassword))
		            	{
							st.executeUpdate("update user set password='"+user.getNewPassword()+"' where password='"+currentPassword+"/");
				            System.out.println("Password changed successfully");	
		            	}
						else
						{
							System.out.println("Retype Password");
						}
		            
		            st.close();
		            con.close();
		            }
		            else{
		            	System.out.println("Invalid Current Password");
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
		   }
}


