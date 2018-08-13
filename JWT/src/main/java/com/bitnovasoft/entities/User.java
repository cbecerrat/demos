package com.bitnovasoft.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {	
	private Integer id;
	private String user;
	private String password;
	private boolean enabled;
	private Integer retries;

	public User(String user, String password){
		this.user = user;
		this.password = password;
	}
}
