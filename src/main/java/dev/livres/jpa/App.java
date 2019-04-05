package dev.livres.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	public static void main(String[] args) {

		// Etape 1 - Créer une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");

		// Début d'une unité de travail
		EntityManager em1 = emf.createEntityManager();

		EntityTransaction transaction = em1.getTransaction();
		transaction.begin();

		// création d'une requête
		TypedQuery<Livre> requete = em1.createQuery("select l from Livre l", Livre.class);

		List<Livre> users = requete.getResultList();

		// Créer une entité Livre ne contenant que l’attribut id auquel je rajoute les
		// autres élements de la table
		for (Livre user : users) {
			System.out.println(user.getId() + " -" + user.getAuteur() + "-" + user.getTitre());
		}

		// Réaliser un find simple permettant d’extraire un livre en fonction de son id.
		Livre find = em1.find(Livre.class, 4);
		if (find != null) {
			System.out.println(find.getId() + "--"+find.getTitre());
		}

		// Faire maintenant une requête JPQL pour trouver un LIVRE en fonction de son nom 
		TypedQuery<Livre> query = em1.createQuery("SELECT t  FROM Livre t WHERE t.titre=:reference", Livre.class);
		query.setParameter("reference", "Germinal");
		
		Livre result = query.getSingleResult();
		System.out.println(result.getTitre());
		
		//Réaliser une requête qui permet d’extraire un emprunt et tous ses livres associés.
		
		TypedQuery<Emprunt>  empr1 = em1.createQuery("select e  from Emprunt e where e.client.id =:numb ", Emprunt.class);
		empr1.setParameter("numb", 2);
		
		List<Emprunt> b  = empr1.getResultList();
		
		for (Emprunt empruntor : b) {
			
			System.out.println(empruntor.getId()+"-"+empruntor.getLivres());
			
		}
		//Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
		
		TypedQuery<Emprunt>  empr = em1.createQuery("select e  from Emprunt e where e.client.id =:hello ", Emprunt.class);
		empr.setParameter("hello", 3);
		
		List<Emprunt> a  = empr.getResultList();
		
		for (Emprunt empruntar : a) {
			
			System.out.println(empruntar.getId()+"-"+empruntar.getLivres());
			
		}
		
		
		
		
		
		
		
		
		transaction.commit();

	}
}