package dev.bibliotheque.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	@Id
	private int id;
	
	@Column(name="DATE_DEBUT")
	private Date dateDebut;
	
	@Column(name="DATE_FIN")
	private Date dateFin;
	
	@Column(name="DELAI")
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
			joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private Set<Livre> livres;
	
	public Emprunt() {
	}
	
	public Emprunt(Set<Livre> livres) {
		super();
		this.livres = livres;
	}


	public String toString() {
		String msg = "Emprunt n°" + id;
		msg += " --> " + client.toString();
		msg += " a emprunté " + livres.size() + " livres.";
		msg += " Date de début : " + dateDebut.toString();
		msg += " Delai : " + delai + " jours.";
		msg += " Date de fin : " + (dateFin != null ? dateFin.toString() : "en cours");
		return msg;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getDelai() {
		return delai;
	}
	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Set<Livre> getLivres() {
		return livres;
	}


	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	
	
}
