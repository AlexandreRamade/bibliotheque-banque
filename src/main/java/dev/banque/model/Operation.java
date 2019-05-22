package dev.banque.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="OPERATION")
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="DATE")
	protected LocalDateTime date;
	
	@Column(name="MONTANT")
	protected double montant;
	
	@Column(name="MOTIF")
	protected String motif;

	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	protected Compte compte;
	
	
	public Operation() {
	}
	

	public Operation(LocalDateTime date, double montant, String motif) {
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}



	public String toString() {
		String msg = "Opération n°" + id;
		msg += " effectué le " + date.toString();
		msg += ". Montant : " + montant + "€";
		msg += " au motif : " + motif;
		return msg;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	
	
	
}
