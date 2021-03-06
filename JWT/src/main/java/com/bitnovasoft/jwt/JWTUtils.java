package com.bitnovasoft.jwt;

import static com.bitnovasoft.utilities.ProjectConstants.*;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
@Log4j
public class JWTUtils {
	private Algorithm algorithm = null;
	private JWTVerifier verifier = null;
	
	public JWTUtils() {
		KeyPairGenerator keyPairGenerator;
		KeyPair keyPair;
		KeyFactory keyFactory;
		
		RSAPublicKeySpec publicKeySpec;
		RSAPrivateKeySpec privateKeySpec;
		
		RSAPublicKey publicRsaKey;
		RSAPrivateKey privateRsaKey;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance(RSA);
			keyPairGenerator.initialize(2048);
			
			// generate the key pair
			keyPair = keyPairGenerator.genKeyPair();

            // create KeyFactory and RSA Keys Specs
            keyFactory = KeyFactory.getInstance(RSA);
            publicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
            privateKeySpec = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);

            // generate (and retrieve) RSA Keys from the KeyFactory using Keys Specs
            publicRsaKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
            privateRsaKey  = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
			
			algorithm = Algorithm.RSA512(publicRsaKey, privateRsaKey);
			verifier = JWT.require(algorithm).withIssuer(JWT_UTILS_CREATE_WITH_ISSUER).build();
		} catch (Exception e) {
			log.error(ERROR_WHILE_GETTING_ALGORITHM);
		} finally {
			keyPairGenerator = null;
			keyPair = null;
			keyFactory = null;
			
			publicKeySpec = null;
			privateKeySpec = null;
			
			publicRsaKey = null;
			privateRsaKey = null;
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
