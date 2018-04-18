package com.bitnovasoft.entities;

import java.util.List;

import lombok.Data;

@Data
public class Medico {
	private Long id;
	private String nombre;
	private String especialidad;
	private List<Cita> citas;
}
