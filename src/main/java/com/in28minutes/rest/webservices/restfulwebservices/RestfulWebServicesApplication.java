package com.in28minutes.rest.webservices.restfulwebservices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.rest.webservices.restfulwebservices.config.LoadingFile;

@SpringBootApplication
public class RestfulWebServicesApplication implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(RestfulWebServicesApplication.class);

	public static void main(String[] args) throws IOException {
		logger.info("starting Application");
		ConfigurableApplicationContext appCtx = SpringApplication.run(RestfulWebServicesApplication.class, args);
		LoadingFile bean = appCtx.getBean(LoadingFile.class); 
		 File data = bean.getData(); 
		 String content = new String(
			      Files.readAllBytes(data.toPath()));
		 System.out.println(content);
		logger.info("Application started");
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info("Executing Command Line Runner => Run ");
		for (int i = 0; i < args.length; ++i) {
			logger.info("args[{}]: {}", i, args[i]);
		}
		

	}
}
