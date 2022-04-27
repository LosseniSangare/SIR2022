package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TagFiche implements Serializable {
	
	private int id;
	private Fiche fiche ;
	private Tag tag ;
	
	public TagFiche() {
		super();
	}

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public Fiche getFiche() {
		return fiche;
	}


	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	@ManyToOne
	public Tag getTag() {
		return tag;
	}


	public void setTag(Tag tag) {
		this.tag = tag;
	}

	
	
	
	
}


