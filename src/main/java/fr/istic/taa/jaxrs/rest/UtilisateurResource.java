package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Kamban;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.dto.UtilisateurDTO;

@Path("api/user")
@Produces(MediaType.APPLICATION_JSON)
public class UtilisateurResource {

	private UtilisateurDao userDAO;

	public UtilisateurResource() {
		userDAO = new UtilisateurDao();
	}
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> getAll() {
		return userDAO.findAll();
	}
	
	@GET
	@Path("/{email}")
	public Utilisateur getUserByEmail(@PathParam("email") String email) {
		return userDAO.findOne(email);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur addUser(Utilisateur user) {
		userDAO.save(user);
		return user;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur saveUserDto(UtilisateurDTO userDto) {
		Utilisateur newUser = Utilisateur.dtoToUtilisateur(userDto);
		userDAO.save(newUser);
		return newUser;
	}
	
}
