package com.bitnovasoft.api.controllers;

import static com.bitnovasoft.utilities.ProjectConstants.MAIN_CONTROLLER_MAPPING_ROOT;
import static com.bitnovasoft.utilities.ProjectConstants.MAIN_CONTROLLER_PARAM_ID;
import static com.bitnovasoft.utilities.ProjectConstants.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitnovasoft.api.repositorios.MedicoDAO;
import com.bitnovasoft.entities.Medico;
import com.bitnovasoft.entities.ResultadoOperacion;

@RestController
@RequestMapping(MAIN_CONTROLLER_MAPPING_ROOT)
public class MainController {
	@Autowired
	private MedicoDAO medicoDAO;		

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public Medico getMedico(@RequestParam(value = MAIN_CONTROLLER_PARAM_ID, required=true) Long id) {
		return medicoDAO.getMedito(id);
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResultadoOperacion createMedico(@RequestBody Medico medico) {
		ResultadoOperacion resultadoOperacion = new ResultadoOperacion(HttpStatus.OK.value(), OK);
		return resultadoOperacion;
	}
}
