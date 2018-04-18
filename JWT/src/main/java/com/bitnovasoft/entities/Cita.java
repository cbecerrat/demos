package com.bitnovasoft.entities;

import lombok.Data;

@Data
public class Cita {
	private Long id;
	private String fecha;
	private String hora;
	private boolean atendida;
}
