package dev.banque.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private int id;
	
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="RUE")
	private String rue;
	
	@Column(name="CODE_POSTAL")
	private int codePostal;
	
	@Column(name="VILLE")
	private String ville;

	public Adresse() {
	}
	
	
	public Adresse(int id, int numero, String rue, int codePostal, String ville) {
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	public String toString() {
		return numero + " " + rue + " " + codePostal + " " + ville.toUpperCase();
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
	
	
	
}
