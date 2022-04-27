package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.dto.FicheDTO;

@Path("/fiches")
@Produces({ "application/json" })
public class FicheRessource {
	private FicheDao fd;

	public FicheRessource() {
		fd = new FicheDao();
	}

	@GET
	@Path("/")
	public List<Fiche> getAllFiche() {
		return fd.findAll();
	}

	@GET
	@Path("/{id}")
	public Fiche getFicheById(@PathParam("id") Long id) {
		return fd.findOne(id);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Fiche addFiche(Fiche fiche) {
		 fd.save(fiche);
		 return fiche;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Fiche saveDto(FicheDTO fdto) {
		Fiche nvlFiche = Fiche.dtoToFiche(fdto);
		fd.save(nvlFiche);
		return nvlFiche;
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Fiche updateFicheById(@PathParam("id") Long id, FicheDTO fdto) throws Exception {
		Fiche f = fd.findOne(id);
		// si id est associé à une fiche dans la bd
		if (f != null) {
			Fiche nvlFiche = Fiche.dtoToFiche(fdto);
			nvlFiche.setId(id);
			
			return fd.update(nvlFiche);
		}
		throw new Exception("aucune fiche associée à l\'id");
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteFiche(@PathParam("id") Long id) throws Exception {
		Fiche f = fd.findOne(id);
		if (f!=null) {
			fd.delete(f);
			return "la fiche "+f.toString()+" est suprimé";
		}
		throw new Exception("Aucune fiche trouver");
	}
	
	@GET
	@Path("/tag/{id}")
	public List<Fiche> getFicheByTagId(@PathParam("id") Long id) {
		return fd.findAllByTagId(id);
	}
	
	@GET
	@Path("/user/{email}")
	public List<Fiche>getFicheByUserEmail(@PathParam("email") String email){
		return fd.FindByUserEmail(email);
	}

}
