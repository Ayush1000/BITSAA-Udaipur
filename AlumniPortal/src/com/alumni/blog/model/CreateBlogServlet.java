package com.alumni.blog.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/CreateBlogServlet")
@MultipartConfig(maxFileSize = 16177215)

public class CreateBlogServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	
	
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		String path = "C:\\Users\\Asus\\git\\BITSAA-Udaipur\\AlumniPortal\\WebContent\\images\\Blog_image";
		String photopath="";
		String author=request.getParameter("author");
		System.out.println(author);
		String title=request.getParameter("title");
		System.out.println(title);
		
		String content =request.getParameter("content");
		System.out.println(content);
		
	Part photo =request.getPart("myfile");
	
	 File file=new File(path);
     
     String fileName = getFileName(photo);
     System.out.println("Filename : "+ fileName);
     
     OutputStream out = null;
     
     InputStream filecontent = null;
       
     PrintWriter writer = response.getWriter();
       
     out = new FileOutputStream(new File(path + File.separator
           + fileName));
   
   filecontent = photo.getInputStream();


   int read = 0;
   final byte[] bytes = new byte[1024];

   while ((read = filecontent.read(bytes)) != -1) {
       out.write(bytes, 0, read);
      
       photopath=path+"/"+fileName;
   }

   System.out.println("path = "+path+"\\"+fileName);
 String pathtoStore = "images/Blog_image"+"/"+fileName;
//   pathtoStore.replace("\\", "\\\\");
	
	
	
		
		BlogBean blog=new BlogBean();
		
		blog.setBlog_author(author);
		System.out.println(blog.getBlog_author());
		
		blog.setBlog_content(content);
		System.out.println(blog.getBlog_content());
		
		blog.setBlog_title(title);
		System.out.println(blog.getBlog_title());
		
		blog.setPhoto(pathtoStore);
		BlogDB blog1=new BlogDB();
		int i=blog1.insertBlog(author,title,content,pathtoStore );
		//int j=blog1.insertBlogPhoto(pathtoStore);
		if(i==1 ){
			System.out.println("Inserted Successfully");
			response.sendRedirect("createBlog.jsp");
		}
		else{
			System.out.println("error");
		}
	}
       private String getFileName(final Part part) {
   	    final String partHeader = part.getHeader("content-disposition");
   	    
   	    for (String content : part.getHeader("content-disposition").split(";")) {
   	        if (content.trim().startsWith("filename")) {
   	            return content.substring(
   	                    content.indexOf('=') + 1).trim().replace("\"", "");
   	        }
   	    }
   	    return null;
   	}

}
