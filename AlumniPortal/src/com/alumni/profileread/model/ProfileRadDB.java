package com.alumni.profileread.model;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import com.alumni.profile.model.ProfileBean;

public class ProfileRadDB {
	 static Connection con;
	   static String url;
	   static ResultSet rs = null; 
	   static Statement st=null;
	         
	   public ProfileReadBean viewProfile(int userid)
	   {
	     
		   ProfileReadBean user = new ProfileReadBean();
		   
	      try
	      {
	         String url ="jdbc:mysql://localhost/alumni"; 

	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         try
	         {               
	            con = DriverManager.getConnection(url,"root","tiger");
	            System.out.println("CONNECTED");
	           st = con.createStatement();
	           String qry="SELECT user.firstname,user.lastname,profile.school,profile.college,profile.university,profile.batch,profile.branch,user.email,user.phonenumber,user.gender,profile.address,profile.companyname,profile.companylocation,profile.position,profile.about,profile.image from user inner join profile on user.userid=profile.userid where user.userid="+userid;
//	           PreparedStatement ps = con.prepareStatement(qry);
	           System.out.println(qry);
	           rs=st.executeQuery(qry);       
	           //qry="UPDATE user SET firstname='"+user.getFirstname()+"', lastname='"+user.getLastname()+"', phonenumber='"+user.getPhonenumber()+"', email='"+user.getEmail()+"'  where userid='"+userid+"'";
	           //System.out.println(qry);
	           //st.executeUpdate(qry); 
//	           ps.executeQuery();
	           while(rs.next())
	           {
	        	   user.setFirstname(rs.getString("firstname"));
	        	   user.setLastname(rs.getString("lastname"));
	        	   user.setSchool(rs.getString("school"));
	        	   user.setCollege(rs.getString("college"));
	        	   user.setUniversity(rs.getString("university"));
	        	   user.setBatch(rs.getInt("batch"));
	        	   user.setBranch(rs.getString("branch"));
	        	   user.setEmail(rs.getString("email"));
	        	   user.setPhonenumber(rs.getString("phonenumber"));
	        	   user.setGender(rs.getString("gender"));
	        	   //user.setUploadphoto(rs.getString("uploadphoto"));
	        	   user.setAddress(rs.getString("address"));
	        	   user.setCompanyname(rs.getString("companyname"));
	        	   user.setCompanylocation(rs.getString("companylocation"));
	        	   user.setPosition(rs.getString("position"));
	        	   user.setAbout(rs.getString("about"));
	                user.setPhoto(rs.getString("image"));
	        	   //user.setFirstname(rs.getString("firstname"));
	        	   //user.setFirstname(rs.getString("firstname"));
	        	   
	        	   System.out.print(user.getFirstname());
	           }
	           
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
}
