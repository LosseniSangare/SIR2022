package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tag implements Serializable{
	private Long id;
	private String libelle;
	private Fiche fiche;
	private TagFiche tag_fiche; 
	
	public Tag() {
		// TODO Auto-generated constructor stub
	}

	public Tag(String libelle, TagFiche tag_fiche ) {
		super();
		this.libelle = libelle;
		this.tag_fiche = tag_fiche;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@ManyToOne
	public Fiche getFiche() {
		return fiche;
	}
	
	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}
	
	@ManyToOne
	public TagFiche getTag_fiche() {
		return tag_fiche;
	}

	public void setTag_fiche(TagFiche tag_fiche) {
		this.tag_fiche = tag_fiche;
	}
	
	
	

}
