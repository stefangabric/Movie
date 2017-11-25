package session;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Category;
import entity.Country;
import entity.Language;
import entity.Movie;
import entity.Score;
import entity.User;

@Stateless
@Remote(Init.class)
public class InitBean implements Init {

	@PersistenceContext(unitName = "Osa")
	protected EntityManager em;

	
	public void init() {
		Category category=new Category("admin", null, null);
		em.persist(category);
		Category category2=new Category("horor", null, null);
		em.persist(category2);
		User user = new User("Admin", "Admin", "admin", "admin", category);
		em.persist(user);
		Language language=new Language("Srpski");
		em.persist(language);
		Date date =new Date();
		Country country=new Country("Srbija");
		em.persist(country);
		Set<Score> scores=new HashSet<Score>();
		Movie movie=new Movie("Zlo", "svakakav", "Perica", "an", "ti", country, language, scores, category2, "1989");
		Score score=new Score(89, date,movie);
		scores.add(score);
		em.persist(movie);
		em.persist(score);
}
}