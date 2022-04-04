package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur implements Serializable{
	private String email ;
	private String nom;
	private List <Fiche>fiche = new ArrayList<Fiche>();
	
	public Utilisateur() {
	}
	
	public Utilisateur(String email, String nom) {
		super();
		this.email = email;
		this.nom = nom;
	}

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
	public List<Fiche> getFiche() {
		return fiche;
	}

	public void setFiche(List<Fiche> fiche) {
		this.fiche = fiche;
	}
	
	
	
}

