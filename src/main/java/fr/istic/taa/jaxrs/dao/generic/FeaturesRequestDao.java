package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.FeaturesRequest;

public class FeaturesRequestDao extends AbstractJpaDao<Long, FeaturesRequest>{
	public FeaturesRequestDao() {
		super(FeaturesRequest.class);
	}
}
