package com.bitnovasoft.api.repositorios;

import static com.bitnovasoft.utilities.Utilities.generateString;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bitnovasoft.entities.Medico;

@Component
public class MedicoDAO {
	@Autowired
	CitaDAO citaDAO;
	
	public Medico getMedito(Long id){
		Medico medico = new Medico();
		
		medico.setId(id);
		medico.setEspecialidad(generateString());
		medico.setNombre(generateString());	
		List<Long> idCitas = new ArrayList<>();
		idCitas.add(1L);
		idCitas.add(2L);
		idCitas.add(3L);
		medico.setCitas(citaDAO.getCitas(idCitas));
		return medico;
	}
}
