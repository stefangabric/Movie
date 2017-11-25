package session;
import java.util.List;

import entity.Movie;

public interface MovieDaoLocal extends GenericDaoLocal<Movie, Integer> {
	public List<Movie> findByCategory(int id);
}
