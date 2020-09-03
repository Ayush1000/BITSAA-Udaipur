package com.alumni.jobs.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;



public class jobDB {

	
	
	public static int add(jobBean job) throws SQLException, ClassNotFoundException{
		
		
		
		String url ="jdbc:mysql://localhost/jobs"; 

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = (Connection) DriverManager.getConnection(url,"root","Ranu31@dec");
        System.out.println("CONNECTED");
        
        Statement st=  con.createStatement();
        String qry="insert into job"+" values('"+job.getName()+"','" +job.getCompanyName()+"','" +job.getDesignation()+"','" +job.getDiscription()+"','" +job.getCity()+"','" +job.getState()+"','" +job.getEmail()+"','" +job.getPhoneNumber()+"','" +job.getDate()+ "')";
        System.out.println(qry);
        
        
        int flag=	st.executeUpdate(qry);
   return flag;
		
		
		
		
		
	}
}
