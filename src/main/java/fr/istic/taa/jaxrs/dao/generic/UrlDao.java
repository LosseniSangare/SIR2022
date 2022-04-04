package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Url;

public class UrlDao extends AbstractJpaDao<Long, Url>{
	public UrlDao() {
		super(Url.class);
	}
	
	public List<Url> getAllUrl(){
		String query = "select distinc f.owner from Fiche as f";
		return this.entityManager.createQuery(query).getResultList();
	}
	
}
