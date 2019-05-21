package dev.bibliotheque;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.bibliotheque.model.Client;
import dev.bibliotheque.model.Emprunt;
import dev.bibliotheque.model.Livre;

public class App {
    public static void main( String[] args ){
        
    	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("bibliotheque-jpa");
        EntityManager em = emFactory.createEntityManager();
        
        
        //Affichage d'un livre trouvé à partir de son ID
        /*
        Livre livre = em.find(Livre.class, 2);
        System.out.println(livre.toString()); */
        
        //Affichage d'un livre trouvé à partir de son titre
        /*
        TypedQuery<Livre> query = (TypedQuery<Livre>) em.createQuery("select livre from Livre livre where livre.titre='Guerre et paix'");
    	
        List<Livre> livres = query.getResultList();
        for(Livre li : livres) {
        	System.out.println(li.toString());
        } */
        
        
        
        //Affichage d'un emprunt et de tous ses livres associés
        
        Emprunt emprunt = em.find(Emprunt.class, 2);
        System.out.println(emprunt.toString());
        for(Livre li : emprunt.getLivres()) {
        	System.out.println("   " + li.toString());
        } 
        
        
        //Affichage de tous les emprunts d'un client donné
        
        Client client = em.find(Client.class, 1);
        System.out.println(client.toString());
        for(Emprunt emp : client.getEmprunts()) {
        	System.out.println("   " + emp.toString());
        } 
        
        
        
        em.close();
        emFactory.close();
        
    }
}
