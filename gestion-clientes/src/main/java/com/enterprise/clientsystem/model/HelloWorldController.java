package com.enterprise.clientsystem.model;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import com.enterprise.clientsystem.business.HelloService;

@ManagedBean
@ViewScoped
@Data
public class HelloWorldController {
	private String firstName = "";
	private String lastName = "";
	
	@Autowired
	HelloService helloService;
	
	public HelloWorldController(){
		
	}

	public String showGreeting() {
		return helloService.sayHello(firstName, lastName);
	}
}
