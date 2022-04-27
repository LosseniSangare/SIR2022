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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.istic.taa.jaxrs.dto.FicheDTO;
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
	private String url ;
	private String hash_git;
	private Utilisateur utilisateur;
	private List<TagFiche> tagFiche = new ArrayList<TagFiche>();
	
	
	public Fiche() {
		super();
	}
	
	

	public Fiche(String libelle, Date date, Date temps, String note, Section section,
			String url,String hash_git, Utilisateur utilisateur){
		super();
		this.libelle = libelle;
		this.date = date;
		this.temps = temps;
		this.note = note;
		this.section = section;
		this.url = url;
		this.hash_git = hash_git;
		this.utilisateur =utilisateur;
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
	
	@Temporal(TemporalType.DATE)
	public java.util.Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Temporal(TemporalType.DATE)
	public java.util.Date getTemps() {
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


	public String getUrl() {
		return url;
	}
	
	public static Fiche dtoToFiche(FicheDTO dto) {
		Fiche f = new Fiche();
		f.date = dto.getDate();
		f.temps = dto.getTemps();
		f.note = dto.getNote();
		f.hash_git = dto.getHash_git();
		return f;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getHash_git() {
		return hash_git;
	}



	public void setHash_git(String hash_git) {
		this.hash_git = hash_git;
	}

	
	@ManyToOne
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	@OneToMany(mappedBy = "fiche",cascade = CascadeType.PERSIST)
	@JsonIgnore
	public List<TagFiche> getTagFiche() {
		return tagFiche;
	}
	
	public void setTagFiche(List<TagFiche> tagFiche) {
		this.tagFiche = tagFiche;
	}



	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	
}
