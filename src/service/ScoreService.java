package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import entity.Movie;
import entity.Score;
import session.MovieDaoLocal;
import session.ScoreDaoLocal;

@Path("/scores")
public class ScoreService {

	@EJB
	private ScoreDaoLocal scoreDao;
	
	@EJB
	private MovieDaoLocal movieDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Score> findAll() {
		List<Score> retVal = null; 
		try {
			retVal = scoreDao.findAll();
			
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR, 
					Status.INTERNAL_SERVER_ERROR);
		}
		return retVal;
	}
	
	@POST
	@Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	public Score create(
			@FormParam("sifra") String sifra, 
	        @FormParam("score") String ocena) {
		Score retVal = null;
		try {

			int ocenai=Integer.valueOf(ocena);
			Date date=new Date();

			Movie movie=movieDao.findById(Integer.valueOf(sifra));
			Score score=new Score(ocenai, date, movie);
			System.out.println("q444");
			retVal = scoreDao.persist(score);
			System.out.println("prosao persist");
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		}
		return retVal;
    }
	
	
    
}