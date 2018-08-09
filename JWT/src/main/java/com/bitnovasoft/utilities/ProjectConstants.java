package com.bitnovasoft.utilities;

import org.springframework.http.MediaType;

public class ProjectConstants {
	public static final String SEPARATOR = "============================================================================";
	public static final String SYSTEM_STARTED = "Systema started...";
	
	public static final String SCAN_API_PACKAGE = "com.bitnovasoft.api";
	public static final String SCAN_JWT_PACKAGE = "com.bitnovasoft.jwt";
	
	public static final String RSA = "RSA";
	
	public static final String EMPTY_STRING = "";
	public static final String HOUR_FORMAT = "HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	public static final String OK = "OK";
	public static final String ERROR = "ERROR";	
	
	public static final String JSON_FORMAT = MediaType.APPLICATION_JSON.toString();
	
	//WADLConfiguration
	public static final String WADL_CONFIGURATION_MAPPING = "/api/.*";
	
	//FilterConfiguration.java
	public static final String FILTER_CONFIGURATION_MAPPING = "/api/**";
	
	//InterceptorPrincipal.java
	public static final String AUTHENTICATION_HEADER = "token";
	
	//WADLController.java
	public static final String WADL_CONTROLLER_MAPPING_ROOT = "/";
	
	//MainController.java
	public static final String MAIN_CONTROLLER_MAPPING_ROOT = "/api/medic";
	
	public static final String MAIN_CONTROLLER_PARAM_ID = "id";	
	
	//LoginController.java
	public static final String LOGIN_CONTROLLER_MAPPING_ROOT = "/login";
	public static final String DEFAULT_USER = "user";
	public static final String DEFAULT_PASSWORD = "password";
	
	public static final String LOGIN_CONTROLLER_PARAM_USER = "user";
	public static final String LOGIN_CONTROLLER_PARAM_PASSWORD = "password";
	
	public static final String LOGIN_CONTROLLER_HEADER_TOKEN = "token";
	public static final String LOGIN_INVALID_CREDENTIALS = "User or Password invalid";
	public static final String LOGIN_SUCCESS = "Success";
	public static final String LOGIN_USER_LOCKED = "User account has been locked due to several login failures";
	public static final Integer LOGIN_MAX_RETRIES = 5;
	
	//JWTUtils.java
	public static final String ERROR_WHILE_GETTING_ALGORITHM = "Eror while getting algorithm...";
	public static final String JWT_UTILS_ALGORITHM_SECRET = "mySuperSecretPassword";
	
	public static final String JWT_UTILS_CREATE_WITH_ISSUER = "myApp";
	public static final String JWT_UTILS_CREATE_WITH_SUBJECT = "authentication";
	public static final String JWT_UTILS_CREATE_WITH_ID = "id";
	
	public static final String MISSING_TOKEN = "There is no token on request";
	public static final String INVALID_TOKEN = "Invalid token";
	public static final String ERROR_WHILE_DECODING_TOKEN = "Eror while decoding token...";
	
	public static final String DB_URL = "${db.url}";
	
	public static final String DB_QUERY_LOGIN = "${db.query.login}";
	public static final String DB_QUERY_LOGIN_UPDATE_RETRIES = "${db.query.login.update.retries}";
	
}
