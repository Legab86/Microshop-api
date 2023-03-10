package com.rizen.controllers;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rizen.domain.Client;
import com.rizen.services.ClientService;

@SpringBootApplication
@RestController
public class MicroshopController {

	ClientService clientService = new ClientService();
	
	public static void main(String[] args) {
		SpringApplication.run(MicroshopController.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "<center><br><br>Welcome to Microshop Market API !<center>";
	}

	// 3. Rajouter une méthode permettant de récuprer en @GET les informations d'un
	// Client via @PathVariable;

	@GetMapping(value = "/clients/{clientid}")
	public Client getClient(@PathVariable("clientid") Long clientid) {
		
		return clientService.getClientByClientId(clientid);

	}
	
	@GetMapping(value = "/clients")
	public List<Client> getClient(){
		return clientService.getAllClient();
	}

	// 4. Appeler le webservice "/users/add" en lui envoyant les informations d'un
	// client et faire en sorte qu'il renvoie un message de confirmation d'ajout en
	// base de données.

	@PostMapping(value = "/clients/add")
	public String addClient(@RequestBody Client client) {
		

		
		clientService.postClientByClient (client);

		if (client == null) {

			return "Missing the Client datas !</center>";

		} else {
			

			return "The Client datas has well been saved !";
		}

	}
	
	

	
	
	
		

}
