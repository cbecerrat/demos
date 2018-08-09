package com.enterprise.clientsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WelcomePageRedirect extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/user/helloworld.jsf");
		registry.addViewController("/error").setViewName("forward:/error.jsf");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);		

		super.addViewControllers(registry);
	}
}
