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

import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.dto.TagDTO;

@Entity
public class Tag implements Serializable{
	private Long id;
	private String libelle;
	private List<TagFiche> tagFiche = new ArrayList<TagFiche>();
	
	public Tag() {
		super();
	}

	public Tag(String libelle) {
		super();
		this.libelle = libelle;
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
	@OneToMany(mappedBy = "tag",cascade = CascadeType.PERSIST)
	public List<TagFiche> getTagFiche() {
		return tagFiche;
	}
	
	public void setTagFiche(List<TagFiche> tagFiche) {
		this.tagFiche = tagFiche;
	}
	
	public static Tag dtoToTag(TagDTO tagDto) {
		Tag tag = new Tag();
		tag.libelle = tagDto.getLibelle();
		return tag;
	}
	

}
