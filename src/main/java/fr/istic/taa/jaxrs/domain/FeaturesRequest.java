package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Request")
public class FeaturesRequest extends Fiche implements Serializable{
	
	private String fonctionnalite;

	public String getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(String fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}
	
}
