package com.in28minutes.rest.webservices.restfulwebservices.config;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
public class LoadingFile {
	@Bean
	public File getData() throws FileNotFoundException {
		return ResourceUtils.getFile("classpath:data/data.sql");
	}
}
