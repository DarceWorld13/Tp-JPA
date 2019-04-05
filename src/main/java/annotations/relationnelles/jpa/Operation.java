package annotations.relationnelles.jpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="Operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(name="date")
	private LocalDateTime date; 
	@Column(name="montant")
	private double montant; 
	@Column(name="motif")
	private String motif;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne 
	@JoinColumn(name = "id_Compte")
	private Compte unCompte; 
	
	
	
	
	
	public Compte getUnCompte() {
		return unCompte;
	}
	public void setUnCompte(Compte unCompte) {
		this.unCompte = unCompte;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	} 
	
	
	
	

}
