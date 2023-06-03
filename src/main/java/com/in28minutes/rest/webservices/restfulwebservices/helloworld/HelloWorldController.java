package com.in28minutes.rest.webservices.restfulwebservices.helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@RestController
public class HelloWorldController {
	

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World v2"; 
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean V2"); 
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World v2, %s", name)); 
	}	
}
