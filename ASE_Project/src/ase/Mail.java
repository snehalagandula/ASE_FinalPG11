package ase;

import java.io.IOException;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Final
 */
@WebServlet("/Final")
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String emailTo=(String) request.getParameter("name");
		
		String emailFrom="manushareddy34@gmail.com";
		                          
		
		String subject="Request for booking an apartment";
	   String body="This is Manusha.I want to book a 1BHK flat.Kindly provide me additional details";
	   String username="manushareddy34@gmail.com";
	   String password="manusha1991";
		sendStatusEmail(emailFrom,  emailTo, subject,  body);
		GMailAuthenticator G=new GMailAuthenticator( username, password);
	
	}
	

		   
	public static void sendStatusEmail(String emailFrom, String emailTo, String subject, String body)
	{
		  String username="manushareddy34@gmail.com";
		   String password="manusha1991";
		   
		try{
			
			
			
			Properties props = new Properties();
			props.put("mail.smtp.auth","false");
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host","smtp.gmail.com");
			props.put("mail.smtp.user","manushareddy34@gmail.com");  					
			props.put("mail.smtp.password","manusha1991");
			props.setProperty("mail.smtp.auth", "true");
					
			
			props.put("mail.smtp.port","587");
			
			//Session session= Session.getInstance(props);
			Session session = Session.getInstance(props, new GMailAuthenticator(username, password));
			Message message = new MimeMessage(session);
			MailcapCommandMap mc = (MailcapCommandMap)CommandMap.getDefaultCommandMap();
			mc.addMailcap("text/html;;x-java-content-handler=com.sun.mail.handlers.text_html");
			mc.addMailcap("text/xml;;x-java-content-handler=com.sun.mail.handlers.text_xml");
			mc.addMailcap("text/plain;;x-java-content-handler=com.sun.mail.handlers.text_plain");
			mc.addMailcap("multipart/*;;x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			mc.addMailcap("message/rfc822;;x-java-content-handler=com.sun.mail.handlers.message_rfc822");
			CommandMap.setDefaultCommandMap(mc);
			message.setFrom(new InternetAddress(emailFrom));
			//for(int i=0;i<emailTo.length;i++)
			//{
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
				
			//}
			
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			body="Dear Admin".concat ("\n\n").concat("Please book this apartment for me");
			messageBodyPart.setText(body);
			Multipart multipart = new MimeMultipart();
			
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport transport=session.getTransport("smtp");
			transport.connect();
			Transport.send(message);
		
		
		}
		
		catch(MessagingException me)
		{
			me.printStackTrace();
			
		}
	}

}
