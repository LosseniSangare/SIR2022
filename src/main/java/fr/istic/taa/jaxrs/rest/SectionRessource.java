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

import fr.istic.taa.jaxrs.dao.generic.SectionDao;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.dto.SectionDTO;

@Path("/section")
@Produces(MediaType.APPLICATION_JSON)
public class SectionRessource {
	
	private SectionDao sd;
	
	public SectionRessource() {
		sd = new SectionDao();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Section addSection(Section section) {
		sd.save(section);
		return section;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Section save(SectionDTO secDTO){
		Section newSection = Section.dtoToSection(secDTO);
		sd.save(newSection);
		return newSection;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Section updateById(@PathParam("id") Long id, SectionDTO secDTO) throws Exception {
		if(sd.findOne(id)!= null) {
			Section newSec = Section.dtoToSection(secDTO);
			newSec.setId(id);
			return sd.update(newSec);
		}
		throw new Exception("aucune section trouver pour cet id");
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteById(@PathParam("id") Long id) throws Exception {
		Section sec = sd.findOne(id);
		if(sec!=null) {
			sd.delete(sec);
			return "Section"+sec.toString()+" est suprimé";
		}
		throw new Exception("aucun Section trouvé");
	}
	
	@GET
	@Path("/{id}")
	@Produces({"application/json"})
	public Section getSectionById(@PathParam("id") Long id) {
		return sd.findOne(id);
	}
	
	@GET
	@Path("/all")
	@Produces({"application/json"})
	public List<Section> getAll(){
		return sd.findAll();
	}
	
	
	
}
