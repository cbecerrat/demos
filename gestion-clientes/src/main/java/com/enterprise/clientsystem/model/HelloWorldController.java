package com.enterprise.clientsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import com.enterprise.clientsystem.business.HelloService;
import com.enterprise.clientsystem.model.entities.Car;

@Data
@Named
@SessionScoped
public class HelloWorldController{
	private String firstName = "";
	private String lastName = "";
	private Integer id = 1;
	private Integer anio = 2000;
	private List<Car> carList = new ArrayList<>();

	@Autowired
	private HelloService helloService;

	public String showGreeting() {
		return helloService.sayHello(firstName, lastName);
	}
	
	public void addOne(){
		carList.add(new Car(id, anio, "Vento", "Black"));
		id++;
		anio++;
	}
}
