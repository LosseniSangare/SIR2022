package fr.istic.taa.jaxrs.dao.generic;


import fr.istic.taa.jaxrs.domain.Kamban;


public class KambanDao extends AbstractJpaDao<Long, Kamban>{
	
	public KambanDao() {
		super(Kamban.class);
	}
	
//	public Kamban getKambanByName(String Name) {
//		String query = "Select k.libelle from Kamban as k where k.libelle = loss";
//		return "dqz";
//}
//	
}
