package com.alumni.jobs.model;

import java.sql.*;



public class jobDB {

	
	
	public static int add(jobBean job) throws SQLException, ClassNotFoundException{
		
		
		
		String url ="jdbc:mysql://localhost/jobs"; 

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = (Connection) DriverManager.getConnection(url,"root","Ranu31@dec");
        System.out.println("CONNECTED");
        
        Statement st=  con.createStatement();
        String qry="insert into job (name,companyname,designation,discription,city,state,total_expirence,relative_expirence,skill,email,phonenumber,start_date,last_date)"+" values('"+job.getName()+"','" +job.getCompanyName()+"','" +job.getDesignation()+"','" +job.getDiscription()+"','" +job.getCity()+"','" +job.getState()+"','" +job.getTotal_expirence()+"','" +job.getRelative_expirence()+"','"+job.getSkill()+"','"+job.getEmail()+"','" +job.getPhoneNumber()+"','"+job.getStart_date()+"','" +job.getDate()+ "')";
        System.out.println(qry);
        
        
        int flag=	st.executeUpdate(qry);
   return flag;
		
		
		
		
		
	}
	public static String getEmailForJobID(int jobid) throws ClassNotFoundException, SQLException{
		

		String url ="jdbc:mysql://localhost/jobs"; 

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = (Connection) DriverManager.getConnection(url,"root","Ranu31@dec");
        System.out.println("CONNECTED");
        
        String qry="select email from job where jobID=?";
        PreparedStatement pst=con.prepareStatement(qry);
        pst.setInt(1,jobid);
        ResultSet rs=pst.executeQuery();
        String to=null;
        if(rs.next()){
        to=rs.getString("email");
        }
		
		
		return to;
		
	}
}
