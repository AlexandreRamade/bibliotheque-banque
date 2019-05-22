package dev.banque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ASSURANCE_VIE")
public class AssuranceVie extends Compte {
	
	@Column(name="DATE_FIN")
	protected LocalDate dateFin;
	
	@Column(name="TAUX")
	protected double taux;

	public AssuranceVie() {
		super();
	}

	public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	
	public String toString() {
		String msg = "Assurance vie - " +  numero + " /";
		msg += " Taux : " + taux;
		msg += ", date de fin : " + dateFin.toString();
		msg += ". Solde : " + solde + "€";
		return msg;
	}
	
	
	
	
	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	

	
}
