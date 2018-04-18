package com.bitnovasoft.api.repositorios;

import static com.bitnovasoft.utilities.ProjectConstants.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bitnovasoft.entities.Cita;

@Component
public class CitaDAO {
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	SimpleDateFormat shf = new SimpleDateFormat(HOUR_FORMAT);
	
	public List<Cita> getCitas(List<Long> ids){
		List<Cita> citas = new ArrayList<>();
		
		for(Long id : ids){
			Cita cita = new Cita();
			citas.add(cita);
			
			Date date = new Date();
			
			cita.setId(id);
			cita.setFecha(sdf.format(date));
			cita.setHora(shf.format(date));
			cita.setAtendida(false);
		}
		
		return citas;
	}
}
