package annotations.relationnelles.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppTest {

	public static void main(String[] args) {
		
		
	
		
		// Insérer en base de données des instances des différents objets en utilisant l’EntityManager
		
		// Etape 1 - Créer une instance d'EntityManagerFactory
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
		
				// Début d'une unité de travail
				EntityManager entitymanager1 = emf.createEntityManager();
				
				//transaction 
				EntityTransaction transaction = entitymanager1.getTransaction();
				transaction.begin();
				
				Client Mcgregor = new Client(); 
				Mcgregor.setNom("Mcgregor");
				Mcgregor.setPrenom("Conor"); 
				Adresse adres1 = new Adresse(); 
				adres1.setCodePostal(91000);
				adres1.setNumero(13);
				adres1.setRue("rue de la mort");
				adres1.setVille("dublin");
				Mcgregor.setAdresse(adres1);
				Mcgregor.setDateDeNaissance(1989);
				//banque 
				Banque cic = new Banque(); 
				cic.setNomBanque("CIC");
				entitymanager1.persist(cic);
				Mcgregor.setUneBanque(cic);
				Mcgregor.setUneBanque(cic);
				//compte 
				Compte compte1 = new Compte(); 
				compte1.setNumerodeCompte("45215F454255F45414");
				compte1.setSolde(10035.65);
				List<Compte> listedecomptes = new ArrayList<Compte>();
				listedecomptes.add(compte1);
				Mcgregor.setListedecomptes(listedecomptes);
				//operation
				Operation ope1 = new Operation(); 
				ope1.setMontant(15.65);
				ope1.setMotif("virement à mon chien");
				ope1.setDate(LocalDateTime.now());
				ope1.setUnCompte(compte1);
				//une liste opration
				List<Operation>listesdoperations = new ArrayList<>(); 
				listesdoperations.add( ope1);
				compte1.setListesdoperation(listesdoperations);
				
				Virement v1 = new Virement(); 
				v1.setBeneficiaire("Ali Baba");
				
				LivretA livrea1 = new LivretA(); 
				livrea1.setTaux(12.65);
				
				AssuranceVie assure = new AssuranceVie(); 
				assure.setDateFin(LocalDate.of(2021, 12, 10));
				assure.setTaux(13.33);
			
			
				entitymanager1.persist(Mcgregor);
				entitymanager1.persist(cic);
				entitymanager1.persist(compte1);
				entitymanager1.persist(ope1);
				entitymanager1.persist(v1);
				entitymanager1.persist(livrea1);
				entitymanager1.persist(assure);
				
				
				
				
				
				
				
				
				
				transaction.commit();
				
				
		
		
		
		

	}

}
