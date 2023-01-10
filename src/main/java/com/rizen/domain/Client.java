package com.rizen.domain;

public class Client {
	public int id;
	public String name;
	public String age;
	
	
	public Client() {
		super();
		
		
	}
	public Client(int id, String nom, String age) {
		super();
		this.id = id;
		this.name = nom;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return name;
	}
	public void setNom(String nom) {
		this.name = nom;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", nom=" + name + ", age=" + age + "]";
	}
	
	

}
