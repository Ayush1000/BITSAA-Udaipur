package com.alumni.jobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.alumni.jobs.model.jobBean;
import com.alumni.jobs.model.jobDB;


@WebServlet("/applyServlet")
@MultipartConfig
public class applyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		 //String from=request.getParameter("email") ;
		// jobBean job=new jobBean();
		// String to =job.getEmail();
		 // System.out.println(to);
		final String from = "gauravoffical21@gmail.com"; // change accordingly
		final String password = "Ranu31@dec"; // change accordingly
//		final String to = "gj21041998@gmail.com";
		// ProfileBean user=new ProfileBean();
		// change accordingly
		// String host = "localhost"; // or IP address

		// Get system properties
		Properties properties = System.getProperties();
		HttpSession s = request.getSession();
		int jobid = Integer.parseInt((String) s.getAttribute("jobid"));
		
		String to;
		try {
			to = jobDB.getEmailForJobID(jobid);
		
		String host = "smtp.gmail.com";

		properties.put("mail.smtp.starttls.enable", "true");

		properties.put("mail.smtp.ssl.trust", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", password);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			try {
				message.setFrom(new InternetAddress(from));
			
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
			
				message.setSubject("JOB APPLICATION");
			
//				message.setText("Following attachment is my resume:");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("To apply for the job. Please find resume Attached.");

			// Create a multipar message
			MimeMultipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			byte[] buffer = new byte[4096];
	        int bytesRead = -1;
			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			Part part = request.getPart("myfile");
			String filename = getFileName(part);
			System.out.println(filename);
//			Path path = Paths.get(filename);
			File file = new File(filename);
			FileOutputStream outputStream = new FileOutputStream(file);
            
            // saves uploaded file
            InputStream inputStream = part.getInputStream();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
//			System.out.println(file.getCanonicalPath());
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(file.getName());
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);
			// Send message
			Transport transport = session.getTransport("smtp");

			transport.connect(host, from, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");
			String msg="Your Resume has been sent ";
			request.setAttribute("msg", msg);
		    getServletContext().getRequestDispatcher("/viewJobs.jsp").forward(request, response);
		    
			//response.sendRedirect("viewJobs.jsp");

		} catch (SendFailedException mex) {
			mex.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
