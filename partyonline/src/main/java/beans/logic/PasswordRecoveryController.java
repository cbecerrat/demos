package beans.logic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import domain.Customer;
import modules.MailSender;
import modules.MailTypes;
import modules.SingleMailParameters;
import repositories.UserRepository;

@RestController
public class PasswordRecoveryController {
	private static final Logger LOGGER = Logger.getLogger(PasswordRecoveryController.class);
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	MailSender mailSender;
	
	@PostMapping(value = "/passwordRecover")	
	public void recoverPassword(@RequestBody Customer _customer){
		String mail = _customer.getEmail();
		
		sendPasswordRecoveryEmail(_customer);
	}
	
	private void sendPasswordRecoveryEmail(final Customer customer) {
		SingleMailParameters parameters = new SingleMailParameters();
		
		parameters.setReceiver(customer.getEmail());
		parameters.setSubject("Recuperar contraseña.");
		parameters.setContent("<html><h1>¡Bienvenido!</h1></br>No olvides visitar nuestro sitio.</html>");
		parameters.setMailType(MailTypes.PASSWORD_RECOVERY);
		
		mailSender.generateAndSendSingleEmail(parameters);
	}
}
