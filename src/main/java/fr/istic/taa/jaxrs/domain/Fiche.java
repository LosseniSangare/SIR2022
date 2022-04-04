package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name ="fiche_type")
public class Fiche implements Serializable {
	
	private Long id;
	private String libelle;
	private Date date;
	private Date temps;
	private String note;
	private Section section;
	private Url url ;
	private HashGit hash_git;
	private Utilisateur utilisateur;
	
	private TagFiche tag_fiche; 
	
	
	public Fiche() {
		super();
	}
	
	

	public Fiche(String libelle, Date date, Date temps, String note, Section section,
			Url url,HashGit hash_git, Utilisateur utilisateur,TagFiche tag_fiche){
		super();
		this.libelle = libelle;
		this.date = date;
		this.temps = temps;
		this.note = note;
		this.section = section;
		this.url = url;
		this.hash_git = hash_git;
		this.utilisateur =utilisateur;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTemps() {
		return temps;
	}

	public void setTemps(Date temps) {
		this.temps = temps;
	}
	
	
	@ManyToOne
	public Section getSection() {
		return section;
	}



	public void setSection(Section section) {
		this.section = section;
	}


	@ManyToOne
	public Url getUrl() {
		return url;
	}


	public void setUrl(Url url) {
		this.url = url;
	}


	@ManyToOne
	public HashGit getHash_git() {
		return hash_git;
	}



	public void setHash_git(HashGit hash_git) {
		this.hash_git = hash_git;
	}

	
	@ManyToOne
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	@ManyToOne
	public TagFiche getTag_fiche() {
		return tag_fiche;
	}



	public void setTag_fiche(TagFiche tag_fiche) {
		this.tag_fiche = tag_fiche;
	}



	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	
}
