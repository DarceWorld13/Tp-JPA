package dev.livres.jpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="emprunt")
public class Emprunt {
	
	@Id
    @Column(name="ID")
    private Integer id;
    @Column(name="DATE_DEBUT")
    private LocalDateTime dateDebut;
    public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@Column(name="DATE_FIN")
    private LocalDateTime dateFin;
    @Column(name="DELAI")
    private Integer delai;
    
	@ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;
	
	@ManyToMany(mappedBy="emprunts")
	private List<Livre> livres;
    
	
    public Emprunt() {
		
		this.livres = new ArrayList<Livre>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	

	
	

	
	

}
