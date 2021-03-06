package dev.livres.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="client")
public class Client {

	@Id // obligatoire
	@Column(name="ID")
	private Integer id;
	

	@Column(name="NOM")
	private String nom; 
	
	@Column(name="PRENOM")
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private List<Emprunt> listes; // référence vers les chambres
	

	public Integer getId() {
		return id;
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

	
	
	
	
	
}
