package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

public class SpringSecurityPlayResource {

	@GetMapping("/csrf-token")
	public CsrfToken retrieveCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
	
}
