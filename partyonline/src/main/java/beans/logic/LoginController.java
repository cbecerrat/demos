package beans.logic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import domain.LoginResult;
import domain.User;
import repositories.UserRepository;

@RestController
public class LoginController {
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	
	@Autowired
	UserRepository ur;
	
	@PostMapping(value = "/login")	
	public LoginResult login(@RequestBody User _user){		
		LOGGER.info("PERFORM LOGIN... [" +  _user + "]");
		
		try {
			User user = ur.findUser(_user.getUsername());
			LOGGER.info(user);
		}catch(Exception e) {
			LOGGER.error("ERROR", e);
		}
		
		LoginResult result = new LoginResult();
		result.setMessage("Hi there!");
		result.setAccessGranted(true);
		
		return result;
	}
}
