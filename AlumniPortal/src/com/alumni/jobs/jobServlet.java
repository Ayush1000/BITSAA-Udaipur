package com.alumni.jobs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alumni.jobs.model.jobBean;
import com.alumni.jobs.model.jobDB;
@WebServlet("/jobServlet")
@MultipartConfig
public class jobServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		doPost(request,response);
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name =request.getParameter("name");
		String companyname =request.getParameter("companyname");
		String designation =request.getParameter("designation");
		String discription =request.getParameter("discription");
		String city =request.getParameter("city");
		String state =request.getParameter("state");
		String email =request.getParameter("email");
		String phonenumber =request.getParameter("phonenumber");
		String date =request.getParameter("lastdate");
		String start_date=request.getParameter("start_date");
		String skill=request.getParameter("skill");
		String total_expirence=request.getParameter("total_expirence");
		String relative_expirence =request.getParameter("relative_expirence ");
		
		
		
		jobBean job=new jobBean();
		
		job.setName(name);
		job.setCity(city);
		job.setCompanyName(companyname);
		job.setDesignation(designation);
		job.setDiscription(discription);
		job.setEmail(email);
		job.setState(state);
		job.setPhoneNumber(phonenumber);
		job.setDate(date);
		job.setRelative_expirence(relative_expirence);
		job.setTotal_expirence(total_expirence);
		job.setSkill(skill);
		job.setStart_date(start_date);
		
		
		
		
		try {
			
			int i=jobDB.add(job);
			if(i==1){
				System.out.println("success");
				response.sendRedirect("jobs.jsp");
			}
			else{
				System.out.println("error");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
