package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.HashGit;


public class HashGitDao extends AbstractJpaDao<Long, HashGit>{
	public HashGitDao() {
		super(HashGit.class);
	}
	
	
	public List<HashGit> getAllHash_git(){
		String query = "select distinc f.owner from Fiche as f";
		return this.entityManager.createQuery(query).getResultList();
	}
}
