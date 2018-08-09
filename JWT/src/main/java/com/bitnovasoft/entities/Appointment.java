package com.bitnovasoft.entities;

import lombok.Data;

@Data
public class Appointment {
	private Long id;
	private String date;
	private String hour;
	private boolean attended;
}
