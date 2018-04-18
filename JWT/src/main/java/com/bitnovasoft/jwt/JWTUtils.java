package com.bitnovasoft.jwt;

import static com.bitnovasoft.utilities.ProjectConstants.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
@Slf4j
public class JWTUtils {
	private Algorithm algorithm = null;
	private JWTVerifier verifier = null;
	
	public JWTUtils() {
		try {
			algorithm = Algorithm.HMAC256(JWT_UTILS_ALGORITHM_SECRET);
			verifier = JWT.require(algorithm).withIssuer(JWT_UTILS_CREATE_WITH_ISSUER).build();
		} catch (Exception e) {
			log.error(ERROR_WHILE_GETTING_ALGORITHM);
		}
	}
	
	public String getToken() {
		String token = EMPTY_STRING;
		
		if(algorithm != null){
			Instant instant = new Date().toInstant();
			Date issuedDate = Date.from(instant);
			Date expirationDate = Date.from(instant.plus(30, ChronoUnit.MINUTES));
			
			token = JWT.create()
				.withIssuer(JWT_UTILS_CREATE_WITH_ISSUER)
				.withSubject(JWT_UTILS_CREATE_WITH_SUBJECT)
				.withJWTId(JWT_UTILS_CREATE_WITH_ID)
				.withIssuedAt(issuedDate)
				.withExpiresAt(expirationDate)
				.sign(algorithm);
		}

		return token;
	}

	public boolean verifyToken(String token) {
		boolean valid = false;
		
		if(verifier != null){
			try{
				DecodedJWT jwt = verifier.verify(token);		
				valid = (jwt != null) ? true : false;
			}catch(Exception e){
				log.error(ERROR_WHILE_DECODING_TOKEN);
			}
		}

		return valid;
	}
}
