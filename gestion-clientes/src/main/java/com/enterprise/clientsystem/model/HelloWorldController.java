package com.enterprise.clientsystem.model;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import com.enterprise.clientsystem.business.HelloService;

@Data
@Named
@ViewScoped
public class HelloWorldController implements Serializable{	
	private static final long serialVersionUID = 1L;
	private String firstName = "";
	private String lastName = "";

	@Autowired
	private HelloService helloService;

	public String showGreeting() {
		return helloService.sayHello(firstName, lastName);
	}
}
