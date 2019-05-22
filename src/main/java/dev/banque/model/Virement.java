package dev.banque.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="VIREMENT")
public class Virement extends Operation {
	
	@Column(name="BENEFICIAIRE")
	protected String beneficiaire;

	public Virement() {
		super();
	}

	public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
		super(date, montant, motif);
		this.beneficiaire = beneficiaire;
	}

	
	public String toString() {
		String msg = "Virement n°" + id;
		msg += " effectué le " + date.toString();
		msg += ". Bénéficiaire : " + beneficiaire;
		msg += ". Montant : " + montant + "€";
		msg += " au motif : " + motif;
		return msg;
	}
	
	
	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
