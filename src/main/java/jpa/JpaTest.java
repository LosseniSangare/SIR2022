package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import domain.Department;
import domain.Employee;

public class JpaTest {

	private static EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			Employee employee = new Employee();
			Department departement =new Department();
//			manager.persist(employee);
//			manager.persist(departement);
			createEmployee();
			listEmployee();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
	
	private static void createEmployee() {
		int numberOfEmployee = manager.createQuery("Select a from Employee a", Employee.class).getResultList().size();
		if(numberOfEmployee == 0) {
			Department departement = new Department("java");
			manager.persist(departement);
			manager.persist(new Employee("Jakab Gipsz",departement));
			manager.persist(new Employee("Captain Nemo",departement));
	
		}
	}
	
	public static void listEmployee() {
		List<Employee> resultList = manager.createQuery("select a from Employee a", Employee.class).getResultList();
		System.out.println("next employee : "+ resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee : "+ next);
		}
	}


}
