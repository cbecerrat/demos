package utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailClient {
	static Properties mailServerProperties;
	static Session session;
	static MimeMessage generateMailMessage;

	public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail();
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}

	public static void generateAndSendEmail() throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("", "");
			}
		});
		
		Message message = new MimeMessage(session);
//		message.setFrom(new InternetAddress("test@mail.com"));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("<--YOUR EMAIL ADDRESS-->"));
		message.setSubject("TEST Mail");
		message.setText("This is a mail for test purposes." +
				"\n\n Regards!");

		Transport.send(message);

		System.out.println("Done");
	}
}
