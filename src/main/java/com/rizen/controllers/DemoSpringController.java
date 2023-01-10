package com.rizen.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rizen.domain.Client;

import java.lang.*;

@SpringBootApplication
@RestController
public class DemoSpringController {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringController.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "<center><br><br>Hello Spring Boot !<center>";
	}
	
	@GetMapping("/hello")
	public String sayHello( @RequestParam(name = "firstName", required = false) String firstName ) {
		
		if(firstName == null || firstName.isEmpty()) {
			
			return "<center><br><br>Hi visitor !</center>";
			
		} else {
			
			return "<center><br><br>Hi " + firstName + " !</center>";
		}
	}
	
//	@PostMapping("/users/{id}")
//	public String getIdUser( @PathVariable("id") int id ) {
//		
//		return "send, yes";
//		
//	}
//	
//	@PostMapping(value="/users/add")
//	public String getUser( @RequestBody Client user ) {
//		
//		return "the user was well received";
//		
//	}
	
	//3. Rajouter un controller qu'on appelle en @get Client qui renvoie le client demandé via @PathVariable;
	
	@GetMapping(value="/users/{id}")
	public String getClient( @PathVariable int id ) {
		
		return "<center><br><br>Hi \" + nom + \" !</center>";
		
	}
	
	
	//4. Appeler le webservice "/users/add" en lui envoyant les informations d'un client et faire en sorte qu'il renvoie un message de confirmation d'ajout en base de données.
	
	@PostMapping(value="/users/add")
	public String getClient( @RequestBody String name ) {
		
if(name == null || name.isEmpty()) {
			
			return "empty customer !</center>";
			
		} else {
			
			return "data received";
		}
		
		
		
	}

}
