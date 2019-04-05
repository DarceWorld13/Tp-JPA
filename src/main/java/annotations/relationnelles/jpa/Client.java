package annotations.relationnelles.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="Client")
public class Client {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(name="nom")
	private String nom; 
	@Column(name="prenom")
	private String prenom; 
	@Column(name="dateDeNaissance")
	private int dateDeNaissance;
	
	@ManyToOne 
	@JoinColumn(name = "ID_BANQUE")
	private Banque uneBanque; 
	
	@ManyToMany
	@JoinTable(name="compte_client",
	joinColumns= @JoinColumn(name="id_t", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="id_d", referencedColumnName="id"))
	private List<Compte>listedecomptes; 
	
	
	
	//le embedded, un client a une adresse
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Embedded
	private Adresse adresse; 
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
	
	public Banque getUneBanque() {
		return uneBanque;
	}
	public void setUneBanque(Banque uneBanque) {
		this.uneBanque = uneBanque;
	}
	public List<Compte> getListedecomptes() {
		return listedecomptes;
	}
	public void setListedecomptes(List<Compte> listedecomptes) {
		this.listedecomptes = listedecomptes;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(int i) {
		this.dateDeNaissance = i;
	} 
	
	

}
