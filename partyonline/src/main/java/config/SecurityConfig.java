package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.authorizeRequests().antMatchers("/servicing/**").access("hasRole('ROLE_ADMIN')")
			.and()
				.formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
			.and()
				.formLogin().loginProcessingUrl("/j_spring_security_check")
			.and()
				.formLogin().defaultSuccessUrl("/servicing/index")
			.and()
				.logout().logoutSuccessUrl("/login?logout")
			.and()
				.csrf()
			.and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
			.and()
				.requiresChannel().anyRequest().requiresSecure();
		
		http.portMapper().http(8080).mapsTo(8443);
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
}
