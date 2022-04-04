package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Bug;

public class BugDao extends AbstractJpaDao<Long, Bug>{

	public BugDao() {
    	super(Bug.class);
	}

}
