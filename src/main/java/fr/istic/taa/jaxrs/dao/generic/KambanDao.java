package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Kamban;


public class KambanDao extends AbstractJpaDao<Long, Kamban>{
	
	public KambanDao() {
		super(Kamban.class);
	}
	

}
