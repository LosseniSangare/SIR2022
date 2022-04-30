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

import fr.istic.taa.jaxrs.dto.SectionDTO;

@Entity
public class Section implements Serializable{
	private Long Id;
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
	public Long getId() {
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
	
	public static Section dtoToSection(SectionDTO sectionDTO) {
		Section s = new Section();
		s.libelle = sectionDTO.getLibelle();
		
		return s;
	}
	

	
}
