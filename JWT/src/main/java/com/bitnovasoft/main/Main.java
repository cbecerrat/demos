package com.bitnovasoft.main;

import static com.bitnovasoft.utilities.ProjectConstants.SCAN_API_PACKAGE;
import static com.bitnovasoft.utilities.ProjectConstants.SCAN_JWT_PACKAGE;
import static com.bitnovasoft.utilities.ProjectConstants.SEPARATOR;
import static com.bitnovasoft.utilities.ProjectConstants.SYSTEM_STARTED;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({SCAN_API_PACKAGE, SCAN_JWT_PACKAGE})
@Slf4j
public class Main extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {		
        return application.sources(Main.class);
    }
	
	public static void main(String [] args) throws Exception{		
		SpringApplication.run(Main.class, args);
		log.info(SEPARATOR);
		log.info(SYSTEM_STARTED);
		log.info(SEPARATOR);
	}		
}
