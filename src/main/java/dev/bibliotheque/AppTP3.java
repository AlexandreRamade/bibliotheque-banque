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
import dev.banque.model.Banque;
import dev.banque.model.Client;
import dev.banque.model.Compte;
import dev.banque.model.Operation;

public class AppTP3 {

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		
		Banque banque = new Banque(1, "Ma Banque");
		
		Client cl1 = new Client(1, "AAA", "aaa", LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_LOCAL_DATE), new Adresse(1, 1, "rue A", 1000, "Aville"));
		Client cl2 = new Client(1, "BBB", "bbb", LocalDate.parse("2002-02-02", DateTimeFormatter.ISO_LOCAL_DATE), new Adresse(2, 2, "rue B", 2000, "Bville"));
		
		Compte compt1 = new Compte(1, "0804002", 300);
		Compte compt2 = new Compte(2, "0804045", 600);
		Compte compt3 = new Compte(3, "0804067", 10);
		
		Operation op = new Operation(1, LocalDateTime.parse("2019-05-21 17:12:05", DateTimeFormatter.ISO_LOCAL_DATE_TIME), 50, "Achat");
		
		
		cl1.setBanque(banque);
		cl2.setBanque(banque);
		
		Set<Compte> set1 = new HashSet<Compte>();
		set1.add(compt1);
		set1.add(compt3);
		cl1.setComptes(set1);
		
		Set<Compte> set2 = new HashSet<Compte>();
		set2.add(compt2);
		set2.add(compt3);
		cl2.setComptes(set2);
		
		Set<Operation> setOp = new HashSet<Operation>();
		setOp.add(op);
		compt1.setOperations(setOp);
		
		
		em.persist(banque);
		em.persist(cl1);
		em.persist(cl2);
		em.persist(compt1);
		em.persist(compt2);
		em.persist(compt3);
		em.persist(op);
		
		
		
		
		
		
		transaction.commit();
		em.close();
		emFactory.close();
		

	}

}
