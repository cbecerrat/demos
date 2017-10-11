package beans.logic;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import domain.Login;
import domain.LoginResult;

@RestController
public class LoginController {
	@PostMapping(value = "/login")	
	public LoginResult login(@RequestBody Login login){		
		System.out.println("PERFORM LOGIN... [" +  login + "]");
		
		LoginResult result = new LoginResult();
		result.setMessage("Hi there!");
		result.setAccessGranted(true);
		
		return result;
	}
}
