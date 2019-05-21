package dev.bibliotheque.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Livre {
	@Id
	private int id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="AUTEUR")
	private String auteur;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;
	
	
	
	public Livre() {
	}

	public Livre(Set<Emprunt> emprunts) {
		super();
		this.emprunts = emprunts;
	}

	public String toString() {
		return "Livre n°" + id + " / Titre : " + titre + " - Auteur : " + auteur;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
}
