package br.edu.unifei.oximeterapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientXController {
	
	private static final String  PORT = "local.server.port";
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/get")
	public String getInstance() {
		return "API Client X running on port: " + environment.getProperty(PORT);
	}

}
