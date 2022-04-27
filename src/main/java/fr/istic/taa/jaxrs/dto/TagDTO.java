package fr.istic.taa.jaxrs.dto;

public class TagDTO {
	
	private String libelle;
	
	public TagDTO(String libelle) {
		this.libelle =libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
