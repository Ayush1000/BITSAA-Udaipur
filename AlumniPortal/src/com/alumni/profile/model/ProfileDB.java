package com.alumni.profile.model;
import java.sql.*;

public class ProfileDB 
{

   static Connection con;
   static String url;
   static ResultSet rs = null; 
   static Statement st=null;
         
   public void profileupdate(ProfileBean user, int userid)
   {
     
      try
      {
         String url ="jdbc:mysql://localhost/alumni"; 

         Class.forName("com.mysql.cj.jdbc.Driver");
         
         try
         {               
            con = DriverManager.getConnection(url,"root","Ranu31@dec");
            System.out.println("CONNECTED");
           st = con.createStatement();
           String qry="update profile set school='"+user.getSchool()+"', college='"+user.getCollege()+"', university='"+user.getUniversity()+"',batch='"+user.getBatch()+"',branch='"+user.getBranch()+"',uploadphoto='"+user.getphoto()+"',address='"+user.getAddress()+"',companyname='"+user.getCompanyname()+"',companylocation='"+user.getCompanylocation()+"',position='"+user.getPosition()+"',about='"+user.getAbout()+"' where userid='"+userid+"'"; 
           System.out.println(qry);
           st.executeUpdate(qry);       
           qry="UPDATE user SET firstname='"+user.getFirstname()+"', lastname='"+user.getLastname()+"', phonenumber='"+user.getPhonenumber()+"'  where userid='"+userid+"'";
           System.out.println(qry);
           st.executeUpdate(qry); 
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
}
} 

