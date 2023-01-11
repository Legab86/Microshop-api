package com.rizen.domain;

public class Client {

	public Long idclient;
	public String nom;
	public String prenom;
	public Long age;
	public String adresse;

	public Client() {
		super();

	}

	public Client(Long idclient, String nom, String prenom, Long age, String adresse) {
		super();
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
	}

	public Long getIdclient() {
		return idclient;
	}

	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", adresse="
				+ adresse + "]";
	}

}
