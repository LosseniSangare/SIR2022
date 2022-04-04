package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.TagFiche;

public class TagFicheDao extends AbstractJpaDao<Long, TagFiche>{
	public TagFicheDao() {
		super(TagFiche.class);
	}
}
