package com.bitnovasoft.api.configuration.interceptores;

import static com.bitnovasoft.utilities.ProjectConstants.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bitnovasoft.entities.OperationResult;
import com.bitnovasoft.jwt.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class InterceptorPrincipal implements HandlerInterceptor{
	private ObjectMapper mapper = new ObjectMapper();	
	
	@Autowired
	JWTUtils jwtUtils;
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{    	
    	String authenticationKey = request.getHeader(AUTHENTICATION_HEADER);
    	boolean bandera = false;
    	
    	if(authenticationKey == null){    		
    		getError(response, BAD_REQUEST.value(), MISSING_TOKEN);
    	}else if(false == jwtUtils.verifyToken(authenticationKey)){
    		getError(response, BAD_REQUEST.value(), INVALID_TOKEN);
    	}else{
    		bandera = true;
    	}
    	
        return bandera;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    
    private void getError(HttpServletResponse response, Integer codigo, String descripcion){
    	OperationResult resultado = new OperationResult(codigo, descripcion);
    	String respuesta = EMPTY_STRING;
    	try {
			respuesta =  mapper.writeValueAsString(resultado);
			response.setContentType(JSON_FORMAT);
			response.setStatus(BAD_REQUEST.value());
	    	response.getWriter().write(respuesta);
		} catch (Exception e) {
			log.error(ERROR, e);
		}    	    	    
    }
}
