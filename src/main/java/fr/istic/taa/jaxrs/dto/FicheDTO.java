package fr.istic.taa.jaxrs.dto;

import java.io.Serializable;
import java.sql.Date;

import fr.istic.taa.jaxrs.domain.Section;

public class FicheDTO implements Serializable {

	private String libelle;
	private Date date;
	private Date temps;
	private String note;
	private Section section;
	private String url;
	private String hash_git;

	public String getHash_git() {
		return hash_git;
	}

	public void setHash_git(String hash_git) {
		this.hash_git = hash_git;
	}

	public FicheDTO(String libelle, Date date, Date temps, String note, Section section,
			String url,String hash_git) {
		super();
		this.libelle = libelle;
		this.date = date;
		this.temps = temps;
		this.note = note;
		this.section = section;
		this.url = url;
		this.hash_git = hash_git;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
