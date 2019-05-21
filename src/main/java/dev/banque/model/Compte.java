package dev.banque.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class Compte {
	
	@Id
	private int id;
	
	@Column(name="NUMERO")
	private String numero;
	
	@Column(name="SOLDE")
	private double solde;

	@ManyToMany(mappedBy="compte")
	public Client client;
	
	@OneToMany(mappedBy="compte")
	public Set<Operation> operations;
	
	public Compte() {
	}
	
	
	public Compte(int id, String numero, double solde) {
		this.id = id;
		this.numero = numero;
		this.solde = solde;
	}



	public String toString() {
		return "Compte " +  numero + " / Solde : " + solde + "€";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Set<Operation> getOperations() {
		return operations;
	}


	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	
	
	
	
}
