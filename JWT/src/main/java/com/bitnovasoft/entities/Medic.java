package com.bitnovasoft.entities;

import java.util.List;

import lombok.Data;

@Data
public class Medic {
	private Long id;
	private String name;
	private String speciality;
	private List<Appointment> appointments;
}
