package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur>{
	
	public UtilisateurDao() {
		super(Utilisateur.class);
	}
	
	public List<Utilisateur> getAllUser(){
		String query = "select distinc k.owner from Fiche as Fi";
		return this.entityManager.createQuery(query).getResultList();
	}
}
