package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import entity.Country;
import session.CountryDaoLocal;

@Path("/countries")
public class CountryService {

	@EJB
	private CountryDaoLocal countryDao;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> findAll() {
		List<Country> retVal = null; 
		try {
			retVal = countryDao.findAll();

			
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR, 
					Status.INTERNAL_SERVER_ERROR);
		}
		return retVal;
	}
	
}
