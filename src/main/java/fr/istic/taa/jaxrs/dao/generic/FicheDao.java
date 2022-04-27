package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Fiche;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {
	public FicheDao() {
		super(Fiche.class);
	}

	@SuppressWarnings("unchecked")
	public List<Fiche> findAllByTagId(long tagId) {
		return entityManager
				.createQuery("select f from Fiche f JOIN TagFiche tf ON f.id=tf.fiche.id WHERE tf.tag.id=:tagid")
				.setParameter("tagid", tagId).getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Fiche>FindByUserEmail(String userEmail){
		return entityManager.
				createQuery("select f from Fiche f JOIN Utilisateur user ON f.utilisateur = user.email WHERE user.email=:userEmail")
				.setParameter("userEmail", userEmail)
				.getResultList();
	}

}
