package annotations.relationnelles.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	

	
	@Column(name="nomdubeneficiaire")
	private String beneficiaire;
	
	
	

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	} 
	
	
	
	
	

}
