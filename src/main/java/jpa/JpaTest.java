package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import fr.istic.taa.jaxrs.dao.generic.BugDao;
import fr.istic.taa.jaxrs.dao.generic.FeaturesRequestDao;
import fr.istic.taa.jaxrs.dao.generic.FicheDao;
import fr.istic.taa.jaxrs.dao.generic.KambanDao;
import fr.istic.taa.jaxrs.dao.generic.SectionDao;
import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.dao.generic.TagFicheDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Bug;
import fr.istic.taa.jaxrs.domain.FeaturesRequest;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Kamban;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.domain.TagFiche;
import fr.istic.taa.jaxrs.domain.Utilisateur;

public class JpaTest {

	private static EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//creation de classe avec dao
		Kamban kamban = new Kamban();
		kamban.setLibelle("PREMIER KAMBAN");
		KambanDao k =new KambanDao();
		k.save(kamban);

		Bug bug = new Bug();
		bug.setSource("Projet sir");
		BugDao b =new BugDao();
		b.save(bug);

		FeaturesRequest Fr =new FeaturesRequest();
		Fr.setFonctionnalite("audite");
		FeaturesRequestDao f = new FeaturesRequestDao();
		f.save(Fr);
			

		Section section = new Section();
		section.setKamban(kamban);
		SectionDao s = new SectionDao();
		s.save(section);	
		
		Utilisateur user = new Utilisateur();
		user.setEmail("lsangare2020@gmail.com");
		user.setNom("sangare");
		UtilisateurDao u = new UtilisateurDao();
//		u.save(user);
		
	
		Fiche fiche = new Fiche();
		fiche.setLibelle("première fiche");
		fiche.setUtilisateur(user);
		FicheDao fdao = new FicheDao();
		fdao.save(fiche);
		
		
		Tag tag = new Tag();
		tag.setLibelle("premier tag_Fiche");
		TagDao td = new TagDao();
		td.save(tag);
		
		TagFiche tf = new TagFiche();
		tf.setFiche(fiche);
		tf.setTag(tag);
		TagFicheDao tfd =new TagFicheDao();
		tfd.save(tf);
		

		
//		manager = EntityManagerHelper.getEntityManager();
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
		try {
//			Employee employee = new Employee();
//			Department departement =new Department();
//			manager.persist(employee);
//			manager.persist(departement);
//			createEmployee();
//			listEmployee();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		tx.commit();


		//manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
	
	
	
	
	
	
//	
//	private static void createEmployee() {
//		int numberOfEmployee = manager.createQuery("Select a from Employee a", Employee.class).getResultList().size();
//		if(numberOfEmployee == 0) {
//			Department departement = new Department("java");
//			manager.persist(departement);
//			manager.persist(new Employee("Jakab Gipsz",departement));
//			manager.persist(new Employee("Captain Nemo",departement));
//	
//		}
//	}
//	
//	public static void listEmployee() {
//		List<Employee> resultList = manager.createQuery("select a from Employee a", Employee.class).getResultList();
//		System.out.println("next employee : "+ resultList.size());
//		for (Employee next : resultList) {
//			System.out.println("next employee : "+ next);
//		}
//	}


}
