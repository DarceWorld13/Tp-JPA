package annotations.relationnelles.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="Banque")
public class Banque {
	
	//ici les attributs
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id; 
  
	 @Column(name="nom")
	private String nomBanque;
	
	@OneToMany(mappedBy="uneBanque")
	private List<Client> listesdeClient;

	
	
	
//getters/setters 

	public String getNomBanque() {
		return nomBanque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	} 
	
	
	
	
	

}
