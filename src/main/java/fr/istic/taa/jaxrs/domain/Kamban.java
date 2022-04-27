package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.istic.taa.jaxrs.dto.KambanDTO;

@Entity
public class Kamban implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String libelle;
	private List<Section> section ;
	
	public Kamban() {
		super();
	}

	public Kamban(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
		section = new ArrayList<Section>();
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "kamban", cascade = CascadeType.PERSIST)
	public List<Section> getSection() {
		return section;
	}

	public void setSection(List<Section> section) {
		this.section = section;
	}
	
	
	public static Kamban dtoToKamban(KambanDTO kdto) {
		Kamban kb = new Kamban();
		kb.libelle = kdto.getLibelle();
		return kb;
	}
	
}
