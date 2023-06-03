package com.in28minutes.rest.webservices.restfulwebservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/*
 * @PropertySources({
 * 
 * @PropertySource("classpath:/properties/application.properties"),
 * 
 * @PropertySource("classpath:/properties/application-dev.properties"),
 * 
 * @PropertySource("classpath:/properties/application-prod.properties") })
 */

@PropertySource("classpath:/properties/application.properties")
@PropertySource("classpath:/properties/application-dev.properties")
@PropertySource("classpath:/properties/application-prod.properties")
public class PropertySourcesConfig {
	/*@Value("${db.driverClassName}")
	private String driverClassName;*/
	
}
