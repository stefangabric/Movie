package session;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Movie;

@Stateless
@Local(MovieDaoLocal.class)
public class MovieDaoBean extends GenericDaoBean<Movie, Integer> implements
MovieDaoLocal {

	@Override
	public List<Movie> findByCategory(int id) {
		Query q = em
				.createNamedQuery("findByCategory");
		q.setParameter(1, id);
		try{
			@SuppressWarnings("unchecked")
			List<Movie> result = q.getResultList();
			return result;
		}catch(Exception e){
			return null;
		}
	}

}
