package dev.banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LIVRET_A")
public class LivretA extends Compte {
	
	@Column(name="TAUX")
	protected double taux;

	public LivretA() {
		super();
	}

	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	public String toString() {
		return "Livret A - " +  this.numero + " / Solde : " + this.solde + "€";
	}
	
	
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	
	
	
}
