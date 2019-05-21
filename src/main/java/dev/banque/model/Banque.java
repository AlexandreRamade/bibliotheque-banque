package dev.banque.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Banque {
	
	@Id
	private int id;
	
	@Column(name="NOM")
	private String nom;

	@OneToMany(mappedBy="banque")
	private Set<Client> clients;
	
	
	public Banque() {
	}

	
	public Banque(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}



	public String toString() {
		return "Banque n°" + id + " / " + nom;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Set<Client> getClients() {
		return clients;
	}


	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
	
	
	
}
