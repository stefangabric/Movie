package service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entity.Category;
import session.CategoryDaoLocal;

@Path("/categories")
public class CategoryService {

	@EJB
	private CategoryDaoLocal catDao;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> findAll() {
		List<Category> retVal = null; 
		try {
			retVal = catDao.findAll();
			
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR, 
					Status.INTERNAL_SERVER_ERROR);
		}
		return retVal;
	}
	
	
	@GET 
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category findById(@PathParam("id") String id) {
		Category retVal = null;
		try {
			retVal = catDao.findById(Integer.parseInt(id));
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		}
		return retVal;
    }
	
	@POST
	@Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam(value = "naziv")
	String name) {
		Category cat=new Category(name, null, null);
		try {
			catDao.persist(cat);
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		}
		URI uri=null;
		try {
			uri = new URI("http://localhost:8080/Osa/Ameni.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.temporaryRedirect(uri).build(); 
    
    }
	@DELETE 
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public String remove(@PathParam("id") String id) {
    	try {
    		catDao.remove(Integer.parseInt(id));
        } catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);		
        }
    	return MessageConstants.RSP_OK;
    }
    
    @POST
    @Path("/mer")
    @Produces(MediaType.APPLICATION_JSON)
	public Response update(@FormParam("id") String id,@FormParam("naziv") String name) {
    	
        Category cat = catDao.findById(Integer.valueOf(id));
        cat.setName(name);
    	try 
        {
        	catDao.merge(cat);
        } catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		}
        URI uri=null;
		try {
			uri = new URI("http://localhost:8080/Osa/Ameni.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.temporaryRedirect(uri).build(); 
    
    }
}
