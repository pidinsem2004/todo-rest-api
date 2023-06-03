package com.in28minutes.rest.webservices.restfulwebservices.helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthController {
	
	//Use to check if the basic auth header 
	//(crypto of username + password combination) is correct
	@GetMapping(path = "/basicauth")
	public String basicAuthCheck() {
		return "success"; 
	}
		
	
}
