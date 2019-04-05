package annotations.relationnelles.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	
	@Column(name="le_taux")
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	} 
	
	
}
