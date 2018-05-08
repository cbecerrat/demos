package com.enterprise.clientsystem.business;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public String sayHello(String firstName, String lastName){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return "Hello " + authentication.getName() + "! " + firstName + " - " + lastName;
	}
}
