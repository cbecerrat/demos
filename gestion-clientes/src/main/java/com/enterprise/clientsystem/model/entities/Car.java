package com.enterprise.clientsystem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	private Integer id;
	private Integer year;
	private String brand;
	private String color;
}
