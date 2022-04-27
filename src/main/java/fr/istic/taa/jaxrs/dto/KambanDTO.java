package fr.istic.taa.jaxrs.dto;

public class KambanDTO {
	
	private String libelle;
	
	public KambanDTO(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
