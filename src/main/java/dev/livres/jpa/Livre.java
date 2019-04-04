package dev.livres.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="livre")

public class Livre {

	@Id // obligatoire
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name="TITRE")
	private String titre; 
	
	@Column(name="AUTEUR")
	private String auteur; 
	
	
	public Livre() {
		this.emprunts = new ArrayList<Emprunt>();
		
	}

	@ManyToMany
	@JoinTable(name="compo", 
			joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
					inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
				private List<Emprunt> emprunts;
	
	

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public Integer getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", emprunts=" + emprunts + "]";
	}
	
	
	
	
	
}
