package beans.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import domain.LoginResult;
import domain.User;
import repositories.UserRepository;

@RestController
public class LoginController {
	@Autowired
	UserRepository ur;
	
	@PostMapping(value = "/login")	
	public LoginResult login(@RequestBody User _user){		
		System.out.println("PERFORM LOGIN... [" +  _user + "]");
		
		try {
			User user = ur.findUser(_user.getUsername());
			System.out.println(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		LoginResult result = new LoginResult();
		result.setMessage("Hi there!");
		result.setAccessGranted(true);
		
		return result;
	}
}
