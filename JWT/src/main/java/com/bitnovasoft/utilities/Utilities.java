package com.bitnovasoft.utilities;

import java.util.UUID;

public class Utilities {
	public static String generateString(){
		return UUID.randomUUID().toString();
	}
}
