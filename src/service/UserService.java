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
import entity.User;
import session.CategoryDaoLocal;
import session.UserDaoLocal;


@Path("/users")
public class UserService {

	@EJB
	private UserDaoLocal userDao;
	@EJB
	private CategoryDaoLocal catDao;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll() {
		List<User> retVal = null; 
		try {
			retVal = userDao.findAll();
			
			
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
    public User findById(@PathParam("id") String id) {
		User retVal = null;
		try {
			retVal = userDao.findById(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				throw new NumberFormatException("nije nasao id");} 
			catch (Exception e) {
				throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
						Status.INTERNAL_SERVER_ERROR);			
		}
		return retVal;
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@FormParam(value = "ime")
	String ime,@FormParam(value = "pime") String pime,
	@FormParam(value = "kime")String kime,
	@FormParam(value = "sifra")String sifra,
	@FormParam(value = "cat")String kat) {
    	
    	Category cat=catDao.findById(Integer.valueOf(kat));
    	User korisnik=new User(ime,pime,kime,sifra,cat);
		try {
			userDao.persist(korisnik);
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
   
    @POST
    @Path("/mer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam(value = "id")
	String id,@FormParam(value = "ime")
	String ime,@FormParam(value = "prezime") String prezime,
	@FormParam(value = "kime")String kime,
	@FormParam(value = "pass")String pass,
	@FormParam(value = "cat")String kat) {
    	Category cat=catDao.findById(Integer.valueOf(kat));
    	User retVal=new User(Integer.valueOf(id),ime, prezime, kime, pass, cat);
		try {
			
			userDao.merge(retVal);
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
    @POST
    @Path("/prof")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateP(@FormParam(value = "id")
	String id,@FormParam(value = "ime")
	String ime,@FormParam(value = "prezime") String prezime,
	@FormParam(value = "kime")String kime,
	@FormParam(value = "pass")String pass,
	@FormParam(value = "kat")String kat) {
    	Category cat=catDao.findById(Integer.valueOf(kat));
    	User retVal=new User(Integer.valueOf(id),ime, prezime, kime, pass, cat);
		try {
			
			userDao.merge(retVal);
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		}
		URI uri=null;
		try {	uri = new URI("http://localhost:8080/Osa/Mmeni.html");
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
    		userDao.remove(Integer.parseInt(id));
        } catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);		
        }
    	return MessageConstants.RSP_OK;
    }
	
    
}