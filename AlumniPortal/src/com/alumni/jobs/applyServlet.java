package com.alumni.jobs;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.alumni.profile.model.ProfileBean;

@WebServlet("/applyServlet")
@MultipartConfig
public class applyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		final String from = "gauravoffical21@gmail.com"; // change accordingly
		final String password = "Ranu31@dec"; // change accordingly
		final String to = "gj21041998@gmail.com";
		// ProfileBean user=new ProfileBean();
		// String to = user.getEmail(); // change accordingly
		// String host = "localhost"; // or IP address

		// Get system properties
		Properties properties = System.getProperties();

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
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Set To: header field of the header.
			try {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Set Subject: header field
			try {
				message.setSubject("JOB APPLICATION");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String url =
			// "http://localhost:8080/VerificationServlet?email="+to+"&uuid="+uniqueID;
			// Now set the actual message
			try {
				message.setText("Following attachment is my resume:");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Create a multipar message
			MimeMultipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = request.getParameter("myfile");
			System.out.println(filename);
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);
			// Send message
			Transport transport = session.getTransport("smtp");

			transport.connect(host, from, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");

		} catch (SendFailedException mex) {
			mex.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
