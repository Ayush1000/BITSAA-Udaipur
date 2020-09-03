package com.alumni.registration.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationProfileDB {
	static Connection con;
	   static String url;
	   static ResultSet rs = null; 
	   static Statement st=null;
	         
	   public RegistrationProfileBean insertProfile(int userid)
	   {
	     
		   RegistrationProfileBean user = new RegistrationProfileBean();
		   
	      try
	      {
	         String url ="jdbc:mysql://localhost/alumni"; 

	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         try
	         {               
	            con = DriverManager.getConnection(url,"root","tiger");
	            System.out.println("CONNECTED");
	           st = con.createStatement();
	           String qry="SELECT * from user where userid="+userid;
	          System.out.println(qry);
	           rs=st.executeQuery(qry);       
	         /**/
	           
	          while(rs.next())
	           {
	        	   user.setFirstname(rs.getString("firstname"));
	        	   user.setLastname(rs.getString("lastname"));
	        	  user.setEmail(rs.getString("email"));
	        	 user.setPhonenumber(rs.getString("phonenumber"));
	        	 user.setGender(rs.getString("gender"));
	        	          	   
	        	   System.out.print(user.getFirstname());
	           }
	          
	          //String query="INSERT INTO profile(userid,school,college,university,batch,branch,uploadphoto,address,companyname,companylocation,position,about) VALUES ("+userid+ ",'" + user.getSchool()+ "','" + user.getCollege()+ "','" + user.getUniversity() +"'," + user.getBatch() +",'"+user.getFirstname()+ "','" + user.getUploadphoto()+ "','" + user.getAddress() + "','" + user.getCompanyname()+"','" + user.getCompanylocation()+"','" + user.getPosition()+"','" + user.getAbout()+ "')";
	        		  
	           
	          //st.executeUpdate(query); 
	         }
	         
	         catch (SQLException e)
	         {
	            e.printStackTrace();
	         }
	      }

	      catch(Exception e)
	      {
	         System.out.println(e);
	      }
	      
	      return user;
	      
	      }
	   public void registration(RegistrationProfileBean user,int userid,String path)
	   {
	     
	      try
	      {
			
	         String url ="jdbc:mysql://localhost/alumni"; 

	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         try
	         {               
	            con = DriverManager.getConnection(url,"root","tiger");
	            System.out.println("CONNECTED");
	           st = con.createStatement();
	           //String  qry="INSERT INTO profile (userid,school,college,university,uploadphoto,batch,branch,address,companyname,companylocation,position,about) VALUES ("+userid+",'"+user.getSchool()+"','"+user.getCollege()+"','"+user.getUniversity()+"','"+user.getUploadphoto()+"',"+user.getBatch()+",'"+user.getBranch()+"','"+user.getAddress()+"','"+user.getCompanyname()+"','"+user.getCompanylocation()+"','"+user.getPosition()+"','"+user.getAbout()+"')";
	           String qry="INSERT INTO profile(userid,school,college,university,batch,branch,address,companyname,companylocation,position,about,image) VALUES ("+userid+ ",'" + user.getSchool()+ "','" + user.getCollege()+ "','" + user.getUniversity() +"'," + user.getBatch() +",'"+user.getBranch()+ "','" + user.getAddress() + "','" + user.getCompanyname()+"','" + user.getCompanylocation()+"','" + user.getPosition()+"','" + user.getAbout()+"','"+ "'?)";
     		   PreparedStatement ps = con.prepareStatement(qry);
     		   ps.setString(1, path);
	           //String qry=  "update profile set school='"+user.getSchool()+"', college='"+user.getCollege()+"', university='"+user.getUniversity()+"',batch='"+user.getBatch()+"',branch='"+user.getBranch()+"',uploadphoto='"+user.getUploadphoto()+"',address='"+user.getAddress()+"',companyname='"+user.getCompanyname()+"',companylocation='"+user.getCompanylocation()+"',position='"+user.getPosition()+"',about='"+user.getAbout()+"' where userid='"+userid+"'";
	           System.out.println(qry);
	           /*st.executeUpdate(qry);*/
	           ps.executeUpdate();
	        
	           
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
