package com.alumni.mailservice;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail 
{
     public static int sendVerificationMain(String uniqueID,String to) throws Exception
     {  
          final String from = "gauravoffical21@gmail.com"; // change accordingly
          final String password = "Ranu31@dec"; // change accordingly
        // String to = "gj21041998@gmail.com"; // change accordingly
         
//          String host = "localhost"; // or IP address

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
          Authenticator auth = new Authenticator()
          {
              public PasswordAuthentication getPasswordAuthentication()
              {
                  return new PasswordAuthentication(from, password);
              }
          };
          Session session = Session.getInstance(properties, auth);

          try
          {
             // Create a default MimeMessage object.
             MimeMessage message = new MimeMessage(session);

             // Set From: header field of the header.
             message.setFrom(new InternetAddress(from));

             // Set To: header field of the header.
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

             // Set Subject: header field
             message.setSubject("Welcome to BITSAA Udaipur!");
             String url = "http://localhost:8080/VerificationServlet?email="+to+"&uuid="+uniqueID;
             // Now set the actual message
             message.setText("Click this link to verify your email: "+url);

             // Send message
             Transport transport = session.getTransport("smtp");


             transport.connect(host, from, password);
             transport.sendMessage(message, message.getAllRecipients());
             transport.close();
             System.out.println("Sent message successfully....");
             
          }
          catch (SendFailedException mex)
          {
             mex.printStackTrace();
          }
          return 1;
     }
}
