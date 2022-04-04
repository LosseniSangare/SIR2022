package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

@Entity
public class Url implements Serializable{
	private int Id;
	private String lien;
	private List <Fiche>fiche = new ArrayList<Fiche>();
	
	public Url() {
		// TODO Auto-generated constructor stub
	}

	public Url(String lien) {
		super();
		this.lien = lien;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	@OneToMany(mappedBy = "url", cascade = CascadeType.PERSIST)
	public List<Fiche> getFiche() {
		return fiche;
	}

	public void setFiche(List<Fiche> fiche) {
		this.fiche = fiche;
	}
	
	

}
