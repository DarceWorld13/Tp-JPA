package annotations.relationnelles.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	
	@Column(name="date_de_fin")
	private LocalDate dateFin; 
	@Column(name="taux")
	private Double taux;
	
	
	
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Double getTaux() {
		return taux;
	}
	public void setTaux(Double taux) {
		this.taux = taux;
	} 
	
	
	
	
	

}
