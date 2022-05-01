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

import fr.istic.taa.jaxrs.dao.generic.TagDao;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.dto.TagDTO;


@Path("api/tag")
//@Produces({"application/json", "application/xml"})
@Produces(MediaType.APPLICATION_JSON)
public class TagResource {
	
	private TagDao td;
	
	public TagResource() {
		td = new TagDao();
	}
	
	@GET
	@Path("/all")
	public List<Tag>getAll(){
		return td.findAll();
	}
	
	@GET
	@Path("/{id}")
	public Tag GetTagById(@PathParam("id") Long id) {
		return td.findOne(id);
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Tag save(Tag tag) {
		td.save(tag);
		return tag;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Tag saveTagDto(TagDTO tagDto) {
		Tag newTag = Tag.dtoToTag(tagDto);
		return newTag;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Tag updateById(@PathParam("id") Long id, TagDTO tagDto) throws Exception {
		if(td.findOne(id)!= null) {
			Tag newTag = Tag.dtoToTag(tagDto);
			newTag.setId(id);
			return td.update(newTag);
		}
		throw new Exception("aucun tag ne correspond a vet id");
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String DeleteById(@PathParam("id") Long id) throws Exception {
		Tag tag = td.findOne(id);
		if(tag != null) {
			td.delete(tag);
			return "tag "+tag.toString()+" supprimé avec succès";
		}
		throw new Exception("Tag non trouvé");
	}
	
}
