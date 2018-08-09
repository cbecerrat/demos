package com.bitnovasoft.api.repositorios;

import static com.bitnovasoft.utilities.Utilities.generateString;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bitnovasoft.entities.Medic;

@Component
public class MedicoDAO {
	@Autowired
	CitaDAO citaDAO;
	
	public Medic getMedico(Long id){
		Medic medico = new Medic();
		
		medico.setId(id);
		medico.setSpeciality(generateString());
		medico.setName(generateString());	
		List<Long> idCitas = new ArrayList<>();
		idCitas.add(1L);
		idCitas.add(2L);
		idCitas.add(3L);
		medico.setAppointments(citaDAO.getCitas(idCitas));
		return medico;
	}
}
