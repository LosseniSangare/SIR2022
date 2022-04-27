package fr.istic.taa.jaxrs.dto;

public class UtilisateurDTO {
	
	private String email;
	private String nom;
	
	public UtilisateurDTO(String email, String nom) {
		super();
		this.email = email;
		this.nom = nom;
	}

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
	
}
