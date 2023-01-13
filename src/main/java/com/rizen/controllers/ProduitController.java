package com.rizen.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rizen.domain.Produit;
import com.rizen.services.ProduitService;

@SpringBootApplication
@RestController

public class ProduitController {
	
	ProduitService produitService = new ProduitService();

	public static void main(String[] args) {
		SpringApplication.run(MicroshopController.class, args);

	}
	
	
	
	@GetMapping(value = "/produit/{idProduit}")
	public Produit getProduit(@PathVariable("idProduit") Long idProduit) {
		
		return produitService.getProduitByIdProduit(idProduit);
	}
	
	
	@PostMapping(value = "/produit/add")
	public void addProduit(@RequestBody Produit produit) {
		
		produitService.postProduit(produit);
		
		if (produit == null) {

			System.out.println("Missing the Client datas !</center>");

		} else {
			

			System.out.println("The Client datas has well been saved !");
		}
	}

}
