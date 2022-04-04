package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import domain.Employee;

public class doaEmployer {

	public List<Employee> getAllEmployee() {
		return EntityManagerHelper.getEntityManager().createQuery("select u from Employee as u", Employee.class).getResultList();
	}

}
