package com.bitnovasoft.api.controllers;

import static com.bitnovasoft.utilities.ProjectConstants.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitnovasoft.entities.Login;
import com.bitnovasoft.entities.ResultadoOperacion;
import com.bitnovasoft.jwt.JWTUtils;

@RestController
@RequestMapping(LOGIN_CONTROLLER_MAPPING_ROOT)
public class LoginController {
	@Autowired
	JWTUtils jwtUtils;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResultadoOperacion login(@RequestBody(required = false) Login login, HttpServletResponse response){
		Integer codigo = BAD_REQUEST.value();
		String mensaje = LOGIN_CONTROLLER_INVALID_CREDENTIALS;
		
		if(DEFAULT_USER.equals(login.getUsuario()) && DEFAULT_PASSWORD.equals(login.getPassword())){
			codigo = HttpStatus.OK.value();
			mensaje = LOGIN_CONTROLLER_SUCCESS;
			response.setHeader(LOGIN_CONTROLLER_HEADER_TOKEN, jwtUtils.getToken());
		}
		
		return new ResultadoOperacion(codigo, mensaje);
	}
}
