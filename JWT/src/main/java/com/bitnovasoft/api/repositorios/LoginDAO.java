package com.bitnovasoft.api.repositorios;

import static com.bitnovasoft.utilities.ProjectConstants.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bitnovasoft.entities.OperationResult;
import com.bitnovasoft.entities.User;

@Repository
@Slf4j
public class LoginDAO {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Value(DB_QUERY_LOGIN)
	private String LOGIN;
	
	@Value(DB_QUERY_LOGIN_UPDATE_RETRIES)
	private String UPDATE_RETRIES;
	
	public OperationResult login(final User _user) {
		OperationResult result = null;

		try {
			String sql = LOGIN;
			SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(_user);
			
			final User user = namedParameterJdbcTemplate
			.queryForObject(sql, namedParameters,
				(rs, rowNum) -> new User(
					rs.getInt("ID"),
					rs.getString("USER"), 
					rs.getString("PASSWORD"),
					rs.getBoolean("ENABLED"),
					rs.getInt("RETRIES")
				)
			);
						
			result = checkPassword(_user, user);			
		}catch(EmptyResultDataAccessException e){
			log.error("No se encontraron datos...");
		}catch(Exception e){
			log.error("Error while querying DB:", e);
		}

		return result;
	}

	private OperationResult checkPassword(final User _user, final User user) {
		OperationResult result = new OperationResult();
		
		if(user == null){
			result.setCode(HttpStatus.FORBIDDEN.value());
			result.setDescription(LOGIN_INVALID_CREDENTIALS);
		}else{
			if(user.isEnabled()){
				if(_user.getPassword().equals(user.getPassword())){
					result.setCode(HttpStatus.OK.value());
					result.setDescription(LOGIN_SUCCESS);
					if(user.getRetries() != 0){
						user.setRetries(0);
						updateRetries(user);
					}
				}else{
					incrementFailedLogin(user);
					result.setCode(HttpStatus.FORBIDDEN.value());
					result.setDescription(LOGIN_INVALID_CREDENTIALS);
				}
			}else{
				result.setCode(HttpStatus.FORBIDDEN.value());
				result.setDescription(LOGIN_USER_LOCKED);
			}
		}
		
		return result;
	}
	
	private void incrementFailedLogin(final User _user) {
		_user.setRetries(_user.getRetries() + 1);
		if(_user.getRetries() >= LOGIN_MAX_RETRIES){
			_user.setEnabled(false);
		}
		
		updateRetries(_user);
	}
	
	private void updateRetries(final User _user){
		String sql = UPDATE_RETRIES;
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(_user);
		
		final Integer result = namedParameterJdbcTemplate.update(sql, namedParameters);
		log.info("Result: " + result);
	}
}
