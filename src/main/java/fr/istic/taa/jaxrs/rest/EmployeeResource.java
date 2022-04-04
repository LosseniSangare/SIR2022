package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Employee;
import fr.istic.taa.jaxrs.dao.generic.doaEmployer;

@Path("/api")
@Produces({"application/json", "application/xml"})
public class EmployeeResource {
	
	doaEmployer daoe = new doaEmployer();
	
	@GET
	@Path("/test")
	public String getEmployeeById() {
		return  "ceci est un text";
	}
	
	
	@GET
	@Path("/allEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployee(){
		return daoe.getAllEmployee();
	}
}
