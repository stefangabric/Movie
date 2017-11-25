package service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import dto.MovieDTO;
import entity.Category;
import entity.Country;
import entity.Language;
import entity.Movie;
import entity.Score;
import session.CategoryDaoLocal;
import session.CountryDaoLocal;
import session.LanguageDaoLocal;
import session.MovieDaoLocal;
import session.ScoreDaoLocal;

@Path("/movies")
public class MovieService {

	@EJB
	private CategoryDaoLocal catDao;
	
	@EJB
	private CountryDaoLocal couDao;
	
	@EJB
	private LanguageDaoLocal lanDao;
	
	@EJB
	private MovieDaoLocal movieDao;
	
	@EJB
	private ScoreDaoLocal scoreDao;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovieDTO> findAll(@FormParam("zanr") String zanr) {
		List<MovieDTO> retVal = null; 
		try {
			List<Movie> ret = movieDao.findAll();
			retVal = new ArrayList<>();
			for(Movie m : ret) {
				if (zanr==null) {
					Double avg=avgg(m);
					MovieDTO moj=new MovieDTO(m,avg);
					retVal.add(moj);
				}
				else{
					if (m.getCategory().getId().toString().equals(zanr)) {
					Double avg=avgg(m);
					MovieDTO moj=new MovieDTO(m,avg);
					retVal.add(moj);
					}
					}
			
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Comparator<MovieDTO> c=new Comparator<MovieDTO>() {
			@Override
			public int compare(MovieDTO s1, MovieDTO s2) {
				return s2.getAvgScore().compareTo(s1.getAvgScore());
			}
		};
		Collections.sort(retVal, c);
		return retVal;
	}
	@GET 
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MovieDTO findById(@PathParam("id") String id) {
		MovieDTO ret = null;
		try {
			double score=0.;
			Movie retVal = movieDao.findById(Integer.parseInt(id));
			ret = new MovieDTO(retVal,score);
			
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		}
		return ret;
    }
	
	@DELETE 
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public String remove(@PathParam("id") String id) {
    	try {
    		movieDao.remove(Integer.parseInt(id));
        } catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);		
        }
    	return MessageConstants.RSP_OK;
    }

	@POST
	@Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	public Response create(@FormParam("naziv") String naziv,@FormParam("opis") String opis,
			@FormParam("godina") String godina,@FormParam("glumci") String glumci,
			@FormParam("producent") String producent,@FormParam("direktor") String direktor,
			@FormParam("kat") String kat,@FormParam("zem") String zem,
			@FormParam("jez") String jez) {

		try {
			Country country=couDao.findById(Integer.valueOf(zem));
			Language language=lanDao.findById(Integer.valueOf(jez));
			Category category=catDao.findById(Integer.valueOf(kat));
			Set<Score>scores=new HashSet<>();
			Movie m=new Movie(naziv, opis, direktor, producent, glumci, country, language, scores, category,godina);
			movieDao.persist(m);
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		};
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
	@Path("/madd")
    @Produces(MediaType.APPLICATION_JSON)
	public Response createM(@FormParam("naziv") String naziv,@FormParam("opis") String opis,
			@FormParam("godina") String godina,@FormParam("glumci") String glumci,
			@FormParam("producent") String producent,@FormParam("direktor") String direktor,
			@FormParam("kat") String kat,@FormParam("zem") String zem,
			@FormParam("jez") String jez) {

		try {
			Country country=couDao.findById(Integer.valueOf(zem));
			Language language=lanDao.findById(Integer.valueOf(jez));
			Category category=catDao.findById(Integer.valueOf(kat));
			Set<Score>scores=new HashSet<>();
			Movie m=new Movie(naziv, opis, direktor, producent, glumci, country, language, scores, category,godina);
			movieDao.persist(m);
		} catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		};
		URI uri=null;
		try {
			
				uri = new URI("http://localhost:8080/Osa/Mmeni.html");	
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.temporaryRedirect(uri).build();
    }
	
	@POST 
    @Path("/mer")
    @Produces(MediaType.APPLICATION_JSON)
	public Response update(@FormParam(value = "id") String id,@FormParam(value = "naziv")
	String naziv,@FormParam(value = "glumci") String glumci,
	@FormParam(value = "direktor")String direktor,@FormParam(value = "godina") String godina,
	@FormParam(value = "opis") String opis,@FormParam(value = "producent") String producent,
	@FormParam(value = "kat") String kat,@FormParam(value = "jez")
	String jez,@FormParam(value = "zem") String zem) {
		int iid=Integer.parseInt(id);
		Country country=couDao.findById(Integer.valueOf(zem));
		Language language=lanDao.findById(Integer.valueOf(jez));
		Category category=catDao.findById(Integer.valueOf(kat));
		Set<Score>score=new HashSet<>();
		for (Score score2 : scoreDao.findAll()) {
			if (score2.getMovie().getId()==Integer.valueOf(id)) {
				score.add(score2);	
			}
		}
		Movie m=new Movie(iid,naziv, opis, direktor, producent, glumci, country, language,score, category, godina);
		
        try {
        	movieDao.merge(m);
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
    @Path("/mmer")
    @Produces(MediaType.APPLICATION_JSON)
	public Response updateM(@FormParam(value = "id") String id,@FormParam(value = "naziv")
	String naziv,@FormParam(value = "glumci") String glumci,
	@FormParam(value = "direktor")String direktor,@FormParam(value = "godina") String godina,
	@FormParam(value = "opis") String opis,@FormParam(value = "producent") String producent,
	@FormParam(value = "kat") String kat,@FormParam(value = "jez")
	String jez,@FormParam(value = "zem") String zem) {
		int iid=Integer.parseInt(id);
		Country country=couDao.findById(Integer.valueOf(zem));
		Language language=lanDao.findById(Integer.valueOf(jez));
		Category category=catDao.findById(Integer.valueOf(kat));
		Set<Score>score=new HashSet<>();
		for (Score score2 : scoreDao.findAll()) {
			if (score2.getMovie().getId()==Integer.valueOf(id)) {
				score.add(score2);	
			}
		}
		Movie m=new Movie(iid,naziv, opis, direktor, producent, glumci, country, language,score, category, godina);
		
        try {
        	movieDao.merge(m);
        } catch (Exception e) {
			throw new ServiceException(MessageConstants.RSP_UNKNOWN_ERROR,
					Status.INTERNAL_SERVER_ERROR);			
		}
        URI uri=null;
		try {
				uri = new URI("http://localhost:8080/Osa/Mmeni.html");	
			} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.temporaryRedirect(uri).build(); 
    }
	
	public Double avgg(Movie m) {
		Double uk=0.;
		List<Score> skorovi1=scoreDao.findAll();
		List<Score> skorovi=new ArrayList<Score>();
		for (Score score1 : skorovi1) {
			if (m.getId()==score1.getMovie().getId()) {
				skorovi.add(score1);
			}
		}
		for (Score score : skorovi) {
			uk=uk+score.getScore();
		}
		Double avg=uk/skorovi.size();
		return avg;
	}
}
