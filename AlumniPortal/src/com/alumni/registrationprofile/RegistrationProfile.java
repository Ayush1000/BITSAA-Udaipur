

package com.alumni.registrationprofile;

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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.alumni.registration.model.RegistrationProfileBean;
import com.alumni.registration.model.RegistrationProfileDB;

/**
 * Servlet implementation class RegistrationProfile
 */
@WebServlet("/RegistrationProfile")
@MultipartConfig(maxFileSize = 16177215)
public class RegistrationProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bch;
		HttpSession session = request.getSession();
		int userid =(int) session.getAttribute("userid");
		
		String path = "C:\\Users\\ACNuser\\workspace\\AlumniPortal\\WebContent\\images\\profilephoto";
		String photopath="";
		String fn = request.getParameter("firstname");   
		String ln = request.getParameter("lastname");   
	    String scl = request.getParameter("school");
	    String clg = request.getParameter("college");    
	    String uni = request.getParameter("university");
	    String eid = request.getParameter("email");    
	    //String pic = request.getParameter("uploadphoto");
	    if(request.getParameter("batch")!=null)
	     bch = Integer.parseInt( request.getParameter("batch"));  
	    else bch=2010;
	    String br=request.getParameter("branch");
	    String phn = request.getParameter("phonenumber");
	    String add = request.getParameter("address");    
	    String cmpny = request.getParameter("companyname");
	    String cmadd = request.getParameter("companylocation");    
	    String pos = request.getParameter("position");
	    String ab = request.getParameter("about");
	    Part photo = request.getPart("profilephoto");
	    File file=new File(path);
       
        String fileName = getFileName(photo);
        
        OutputStream out = null;
        
          InputStream filecontent = null;
          
          PrintWriter writer = response.getWriter();
          try {
      out = new FileOutputStream(new File(path + File.separator
              + fileName));
      
      filecontent = photo.getInputStream();
   

      int read = 0;
      final byte[] bytes = new byte[1024];

      while ((read = filecontent.read(bytes)) != -1) {
          out.write(bytes, 0, read);
         
          photopath=path+"/"+fileName;
      }
          }
      catch(Exception e)
      {
          System.out.println(e);
      }
          System.out.println("path = "+path+"\\"+fileName);
        String pathtoStore = "images\\profilephoto"+"\\"+fileName;
          pathtoStore.replace("\\", "\\\\");
 RegistrationProfileBean user=new RegistrationProfileBean();
	    
	   user.setAbout(ab);
	   user.setAddress(add);
	   user.setBatch(bch);
	   user.setBranch(br);
	   user.setCollege(clg);
	   user.setCompanylocation(cmadd);
	   user.setCompanyname(cmpny);
	   user.setPhonenumber(phn);
	   user.setPosition(pos);
	   user.setSchool(scl);
	   user.setUniversity(uni);
	   //user.setUploadphoto(pic);
	   user.setFirstname(fn);
	   user.setLastname(ln);
	   user.setEmail(eid);
	   user.setPhoto(pathtoStore);
	  // HttpSession session = request.getSession(true);
	   //String email=(String)session.getAttribute("email"); 
	   /*int userid1 = (int) session.getAttribute("userid");*/
	    
	    RegistrationProfileDB reg=new RegistrationProfileDB();
	    reg.insertProfile(userid);
	    reg.registration(user,userid,path+"\\"+fileName);
	    String msg = "Registration for "+fn+"is Completed !";
	    request.setAttribute("msg", msg);
	    getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
	    
		
		// TODO Auto-generated method stub
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
