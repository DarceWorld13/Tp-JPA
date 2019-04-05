package annotations.relationnelles.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
  
	@Column(name="numerodeCompte")
	private String numerodeCompte; 
	@Column(name="solde")
	private Double solde;
	
	
	@OneToMany(mappedBy="unCompte")
	private List<Operation> listesdoperation; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToMany(mappedBy = "listedecomptes")
	private List<Client> listedeclients; 
	
	public String getNumerodeCompte() {
		return numerodeCompte;
	}
	public void setNumerodeCompte(String numerodeCompte) {
		this.numerodeCompte = numerodeCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public List<Operation> getListesdoperation() {
		return listesdoperation;
	}
	public void setListesdoperation(List<Operation> listesdoperation) {
		this.listesdoperation = listesdoperation;
	}
	public List<Client> getListedeclients() {
		return listedeclients;
	}
	public void setListedeclients(List<Client> listedeclients) {
		this.listedeclients = listedeclients;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	} 
	

}
