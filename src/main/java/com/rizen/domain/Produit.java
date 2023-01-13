package com.rizen.domain;

public class Produit {
	public Long idProduit;
	public String reference;
	public String nomProduit;
	public Long stock;
	
	
	public Produit() {
		super();
	}


	public Produit(Long idproduit, String reference, String nomProduit, Long stock) {
		super();
		this.idProduit = idproduit;
		this.reference = reference;
		this.nomProduit = nomProduit;
		this.stock = stock;
	}


	public Long getIdproduit() {
		return idProduit;
	}


	public void setIdproduit(Long idproduit) {
		this.idProduit = idproduit;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getNomProduit() {
		return nomProduit;
	}


	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}


	public Long getStock() {
		return stock;
	}


	public void setStock(Long stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Produit [idproduit=" + idProduit + ", reference=" + reference + ", nomProduit=" + nomProduit
				+ ", stock=" + stock + "]";
	}
	
	
	
	

}
