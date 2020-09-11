package com.alumni.blog.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BlogDB {
	 static Connection con;
	   static String url;
	   static ResultSet rs = null; 
	   static Statement st=null;
	
	public int insertBlog(String author , String title, String content ,String pathtoStore){
		
		int i=0;
//		BlogBean blog=new BlogBean();
		String url ="jdbc:mysql://localhost/jobs"; 

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,"root","Ranu31@dec");
            System.out.println("CONNECTED");
           st = con.createStatement();
			String qry="insert into blog (blog_title,blog_author,blog_content,blog_date,image_path) "+" values( '"+title+"','"+author+"','"+content+"','"+System.currentTimeMillis()+"','"+pathtoStore+"')";
			
			 System.out.println(qry);
	            i=st.executeUpdate(qry);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		return i;
		
	}

//	public int insertBlogPhoto(String pathtoStore) {
//		
//		int j=0;
//		// TODO Auto-generated method stub
//		
//		String url ="jdbc:mysql://localhost/jobs"; 
//
//        try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			con = DriverManager.getConnection(url,"root","Ranu31@dec");
//            System.out.println("CONNECTED");
//           st = con.createStatement();
//           
//			String qry="insert into blog_image (blog_title,blog_author,blog_content,blog_date) "+" values( '"+title+"','"+author+"','"+content+"','"+System.currentTimeMillis()+"') ";
//			
//			 System.out.println(qry);
//	            j=st.executeUpdate(qry);
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
//		return j;
//	}
	
	public static int updateBlog(int blog_id,String title,String author,String date,String content) throws ClassNotFoundException, SQLException{
		
		int i=0;
//		BlogBean blog=new BlogBean();
		String url ="jdbc:mysql://localhost/jobs"; 

       
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,"root","Ranu31@dec");
			
            System.out.println("CONNECTED");
            
            String qry ="update blog set blog_title='"+title+"' ,blog_author='"+author+"' ,blog_date='"+date+"', blog_content='"+content+"' where blog_id="+blog_id;
             System.out.println(qry );
           /* PreparedStatement pst=con.prepareStatement(qry);
            pst.setInt(1,blog_id);
           */
             st = con.createStatement();
            i=st.executeUpdate(qry);
            
            
            
            return i;
	}

}
