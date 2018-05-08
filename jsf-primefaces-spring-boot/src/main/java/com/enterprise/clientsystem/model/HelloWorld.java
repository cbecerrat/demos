package com.enterprise.clientsystem.model;

import javax.inject.Named;

import lombok.Data;

@Named
@Data
public class HelloWorld {
	private String firstName = "Some";
	private String lastName = "User";

	public String showGreeting() {
		return "Hello " + firstName + " " + lastName + "!";
	}
}
