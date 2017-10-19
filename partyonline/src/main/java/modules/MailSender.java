package modules;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MailSender {
	private final Logger LOGGER = Logger.getLogger(MailSender.class);
	private final Properties MAIL_PROPERTIES = new Properties();
	private final String MAIL_CONTENT_TYPE = "text/html; charset=utf-8";
	private final String MAIL = System.getenv("MAIL_ACCOUNT");
	private final String PASSWORD = System.getenv("MAIL_PASSWORD");
	
	private final String MAIL_SENT = "{%1$s} mail sent to {%2$s}";
	private final String ERROR_SENDING_MAIL = "Error while sending {%1$s} mail to {%2$s}";
	private final Session session = Session.getDefaultInstance(MAIL_PROPERTIES, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(MAIL, PASSWORD);
		}
	});
	
	@PostConstruct
	public void init() {
		MAIL_PROPERTIES.put("mail.smtp.host", "smtp.gmail.com");
		MAIL_PROPERTIES.put("mail.smtp.socketFactory.port", "465");
		MAIL_PROPERTIES.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		MAIL_PROPERTIES.put("mail.smtp.auth", "true");
		MAIL_PROPERTIES.put("mail.smtp.port", "465");
		
		LOGGER.info("MAIL: " + MAIL);
	}

	public void generateAndSendSingleEmail(SingleMailParameters parameters){
		try {
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(parameters.getReceiver()));
			message.setSubject(parameters.getSubject());
			message.setContent(parameters.getContent(), MAIL_CONTENT_TYPE);
			
			Transport.send(message);
			
			LOGGER.info(String.format(MAIL_SENT, parameters.getMailType(), parameters.getReceiver()));
		}catch(Exception e) {
			LOGGER.info(String.format(ERROR_SENDING_MAIL, parameters.getMailType(), parameters.getReceiver()));
		}
	}
	
	public void generateAndSendMassiveEmail(MassiveMailParameters parameters){
		try {
			Message message = new MimeMessage(session);			
			
			for(String receiver : parameters.getReceivers()) {
				message.addRecipients(RecipientType.BCC, InternetAddress.parse(receiver));
			}
			
			message.setSubject(parameters.getSubject());
			message.setContent(parameters.getContent(), MAIL_CONTENT_TYPE);
			
			Transport.send(message);
			
			LOGGER.info(String.format(MAIL_SENT, parameters.getMailType(), parameters.getReceivers()));
		}catch(Exception e) {
			LOGGER.info(String.format(ERROR_SENDING_MAIL, parameters.getMailType(), parameters.getReceivers()));
		}
	}
}
