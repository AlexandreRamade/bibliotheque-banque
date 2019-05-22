package dev.bibliotheque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.banque.model.Adresse;
import dev.banque.model.AssuranceVie;
import dev.banque.model.Banque;
import dev.banque.model.Client;
import dev.banque.model.Compte;
import dev.banque.model.LivretA;
import dev.banque.model.Operation;
import dev.banque.model.Virement;

public class AppTP3 {

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//-------------------- Création des éléments
		Banque banque = new Banque("Ma Banque");
		
		Client cl1 = new Client("AAA", "aaa", LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_LOCAL_DATE), new Adresse(1, "rue A", 1000, "Aville"));
		Client cl2 = new Client("BBB", "bbb", LocalDate.parse("2002-02-02", DateTimeFormatter.ISO_LOCAL_DATE), new Adresse(2, "rue B", 2000, "Bville"));
		
		Compte compt1 = new Compte("0804002", 300);
		Compte compt2 = new Compte("0804045", 600);
		Compte compt3 = new Compte("0804067", 10);
		
		Operation op = new Operation(LocalDateTime.parse("2019-05-21T17:12:05", DateTimeFormatter.ISO_LOCAL_DATE_TIME), 50, "Achat");
		
		//Eléments liés à l'héritage
		
		LivretA livA = new LivretA("0105008", 1000, 0.5);
		AssuranceVie assur = new AssuranceVie("5806021", 14000, LocalDate.parse("2030-05-23", DateTimeFormatter.ISO_LOCAL_DATE), 2.5);
		
		Virement vir1 = new Virement(LocalDateTime.parse("2019-05-21T17:12:05", DateTimeFormatter.ISO_LOCAL_DATE_TIME), 70, "Virrement compte à compte", "AAA");
		
		
		
		//-----------------Remplissage des éléments
		
		cl1.setBanque(banque);
		cl2.setBanque(banque);
		
		Set<Compte> set1 = new HashSet<Compte>();
		set1.add(compt1);
		set1.add(compt3);
		set1.add(livA);		//héritage
		cl1.setComptes(set1);
		
		Set<Compte> set2 = new HashSet<Compte>();
		set2.add(compt2);
		set2.add(compt3);
		set2.add(assur);	//héritage
		cl2.setComptes(set2);
		
		Set<Operation> setOp = new HashSet<Operation>();
		setOp.add(op);
		setOp.add(vir1);
		compt1.setOperations(setOp);
		
		
		
		//------------------Ajout des éléments à la DB
		
		em.persist(banque);
		em.persist(cl1);
		em.persist(cl2);
		em.persist(compt1);
		em.persist(compt2);
		em.persist(compt3);
		em.persist(livA);
		em.persist(assur);
		em.persist(op);
		em.persist(vir1);
		
		
		transaction.commit();
		
		
		
		
		
		//Verification
		Client clTest = em.find(Client.class, 1);
		for(Compte compte : clTest.getComptes()) {
			System.out.println(compte.toString());
			if(compte.getOperations() != null) {
				for(Operation oper : compte.getOperations()) {
					System.out.println("   " + oper.toString());
				}
			}
		}
		
		
		
		
		
		
		//-----------------Fermeture des EntityManager...
		em.close();
		emFactory.close();
		

	}

}
