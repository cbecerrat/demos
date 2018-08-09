package com.bitnovasoft.api.repositorios;

import static com.bitnovasoft.utilities.ProjectConstants.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bitnovasoft.entities.Appointment;

@Component
public class CitaDAO {
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	SimpleDateFormat shf = new SimpleDateFormat(HOUR_FORMAT);
	
	public List<Appointment> getCitas(List<Long> ids){
		List<Appointment> citas = new ArrayList<>();
		
		for(Long id : ids){
			Appointment cita = new Appointment();
			citas.add(cita);
			
			Date date = new Date();
			
			cita.setId(id);
			cita.setDate(sdf.format(date));
			cita.setHour(shf.format(date));
			cita.setAttended(false);
		}
		
		return citas;
	}
}
