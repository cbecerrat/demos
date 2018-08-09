package com.bitnovasoft.api.configuration;

import static com.bitnovasoft.utilities.ProjectConstants.DB_URL;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJdbcConfig {
	@Value(DB_URL)
	private String url;
	
    @Bean
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
 
        return dataSource;
    }
    
    @Bean
    public NamedParameterJdbcTemplate createNamedParameterJdbcTemplate(){
    	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(createDataSource());
    	
    	return namedParameterJdbcTemplate;
    }
}
