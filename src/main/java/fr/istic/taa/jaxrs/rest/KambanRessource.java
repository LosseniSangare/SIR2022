package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.generic.KambanDao;
import fr.istic.taa.jaxrs.domain.Kamban;
import fr.istic.taa.jaxrs.dto.KambanDTO;

@Path("/kamban")
//@Produces(MediaType.APPLICATION_JSON)
@Produces({"application/json", "application/xml"})
public class KambanRessource {
	
	private KambanDao kd;
	
	public KambanRessource() {
		 kd = new KambanDao();	
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Kamban addKamban(Kamban kanban) {
		 kd.save(kanban);
		 return kanban;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Kamban save(KambanDTO kbDto) {
		Kamban newKanban = Kamban.dtoToKamban(kbDto);
		kd.save(newKanban);
		return newKanban;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Kamban UpdateById(@PathParam("id") Long id, KambanDTO kbDto) throws Exception {
		if(kd.findOne(id) != null) {
			Kamban newKb = Kamban.dtoToKamban(kbDto);
			newKb.setId(id);
			return kd.update(newKb);
		}
		throw new Exception("auncun kamban trouvé");
		}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteFiche(@PathParam("id") Long id) throws Exception {
		Kamban kamb = kd.findOne(id);
		if(kamb!=null) {
			kd.delete(kamb);
			return "Kamban"+kamb.toString()+" est suprimé";
		}
		throw new Exception("aucun kamban trouvé");
	}
	
	
	 @GET
	 @Path("/{id}")
	 @Produces({"application/json"})
	  public Kamban getKambanById(@PathParam("id") Long id)  {
		    return kd.findOne(id);
	  }
	
	
	
	@GET
	@Path("/all")
	@Produces({"application/json"})
	public List<Kamban> getAll(){
		return  kd.findAll();
	}
	
	

}
