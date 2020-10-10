package com.demo.eventmanagement.Survey.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.eventmanagement.Survey.entity.Material;
import com.demo.eventmanagement.Survey.entity.QuestionBank;
import com.demo.eventmanagement.Survey.entity.User;

import java.util.List;


public class SendEmailHelperService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	List<String> emailAddress = new ArrayList<>();
	
	private int count = 0;
	public void sendMail(List<User> users, QuestionBank surveyPage, Material material){
		
		Address[] emailAddress = new Address[users.size()];
		try {
			
			for(User user: users) {
				emailAddress[count] = user.getEmailId();
				count++;
			}
		}catch(Exception ex) {
			
			log.info(ex.getMessage());
		}
		
		try {
			
			sendmail(emailAddress, surveyPage, material);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	private void sendmail(Address[] usersEmail,QuestionBank surveyPage, Material material) 
			throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("tutorialspoint@gmail.com", "<your password>");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, usersEmail);
		   msg.setSubject("Tutorials point email");
		   msg.setContent(surveyPage, "text/html");
		   msg.setContent(material, "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("Tutorials point email", "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   MimeBodyPart attachPart = new MimeBodyPart();

		   attachPart.attachFile("/var/tmp/image19.png");
		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
	

}
