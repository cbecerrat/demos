package com.bitnovasoft.api.controllers;

import static com.bitnovasoft.utilities.ProjectConstants.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitnovasoft.api.repositorios.LoginDAO;
import com.bitnovasoft.entities.Login;
import com.bitnovasoft.entities.OperationResult;
import com.bitnovasoft.entities.User;
import com.bitnovasoft.jwt.JWTUtils;

@RestController
@RequestMapping(LOGIN_CONTROLLER_MAPPING_ROOT)
public class LoginController {
	@Autowired
	private JWTUtils jwtUtils;
	
	@Autowired
	private LoginDAO dao;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public OperationResult login(@RequestBody(required = false) Login login, HttpServletResponse response){
		OperationResult result = dao.login(new User(login.getUser(), login.getPassword()));
		
		if(result == null){
			result = new OperationResult();
			result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			result.setDescription(SERVICE_NOT_AVAILABLE);
		}else{
			if(result.getCode() == 200){
				response.setHeader(LOGIN_CONTROLLER_HEADER_TOKEN, jwtUtils.getToken());
			}
		}
		
		return result;
	}
}
