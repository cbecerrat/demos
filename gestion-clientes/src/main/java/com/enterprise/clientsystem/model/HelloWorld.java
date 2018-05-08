package com.enterprise.clientsystem.model;

import javax.inject.Named;

import lombok.Data;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
@Data
public class HelloWorld {
	private String firstName = "";
	private String lastName = "";

	public String showGreeting() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return "Hello " + authentication.getName() + "!";
	}
}
