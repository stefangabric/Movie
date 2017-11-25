package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import entity.Language;
import session.LanguageDaoLocal;

@Path("/languages")
public class LanguageService {

	@EJB
	private LanguageDaoLocal lanDao;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Language> findAll() {
		List<Language> retVal = null; 
		try {
			retVal = lanDao.findAll();
			
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR, 
					Status.INTERNAL_SERVER_ERROR);
		}
		return retVal;
	}
}
