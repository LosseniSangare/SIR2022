package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Section implements Serializable{
	private long Id;
	private String libelle;
	private Kamban kamban; 
	private List<Fiche> fiche =new ArrayList<Fiche>();
	
	public Section() {
		super();
	}

	
	public Section(String libelle, Kamban kamban) {
		super();
		this.libelle = libelle;
		this.kamban = kamban;
	}


	@Id
	@GeneratedValue
	public long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	@ManyToOne
	public Kamban getKamban() {
		return kamban;
	}

	
	public void setKamban(Kamban kamban) {
		this.kamban = kamban;
	}


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(mappedBy="section", cascade = CascadeType.PERSIST)
	public List<Fiche> getFiche() {
		return fiche;
	}

	public void setFiche(List<Fiche> fiche) {
		this.fiche = fiche;
	}


	
}
