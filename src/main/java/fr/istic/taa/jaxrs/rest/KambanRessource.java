package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.KambanDao;
import fr.istic.taa.jaxrs.domain.Kamban;

@Path("/kamban")
@Produces(MediaType.APPLICATION_JSON)
public class KambanRessource {
	
	KambanDao kd = new KambanDao();
		
	 @GET
	 @Path("/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	  public Response getKambanById(@PathParam("id") Long id)  {
	      // return pet
		    return Response.ok().entity("Test ok").build();
	  }
	
	
	
	
	@GET
	@Path("/all")
	public List<Kamban> getAll(){
		return  kd.findAll();
	}
//	
//	@POST
//    @Path("/add")
//    @Consumes("application/json")
//	public Response addKamban() {
//		return kd.save(entity);
//	}
//	
}
