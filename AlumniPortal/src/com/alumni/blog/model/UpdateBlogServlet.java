package com.alumni.blog.model;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBlogServlet")
public class UpdateBlogServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String date=request.getParameter("date");
		String content=request.getParameter("content");
		int blog_id = Integer.parseInt(request.getParameter("blog_id"));
		int i = 0;
		try {
			i = BlogDB.updateBlog(blog_id, title, author, date, content);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1){
			System.out.println("Success");
		}
		else{
			System.out.println("error");
		}
	}
}
