package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@NamedQuery(
	    name="findByCategory",
	    query="SELECT k FROM Movie k WHERE k.category.id = ?1")

@Entity
@Table(name = "movie")
public class Movie implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "movie_id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "title", unique = true, nullable = true,length=80)
	private String title;
	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "director", unique = false, nullable = true,length=120)
	private String director;

	@Column(name = "producer", unique = false, nullable = true,length=120)
	private String producer; 
	@Column(name = "actors", unique = false, nullable = true)
	private String actors;
    @ManyToOne
	@JoinColumn(name = "movie_country_id", referencedColumnName = "country_id", nullable = true)
	private Country country;
    @ManyToOne
	@JoinColumn(name = "movie_language_id", referencedColumnName = "language_id", nullable = true)
	private Language language;
    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "movie")
	private Set<Score> scores = new HashSet<Score>();
	
	public void add(Score s) {
		if (s.getMovie() != null)
			s.getMovie().getScores().remove(s);
		s.setMovie(this);
		scores.add(s);
	
	}

	public void remove(Score s) {
		s.setMovie(null);
		scores.remove(s);
	}
	
	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	
	public Movie(String title, String description, String director, String producer, String actors,
			Country country, Language language, Set<Score> scores, Category category, String movie_year) {
		super();
		this.title = title;
		this.description = description;
		this.director = director;
		this.producer = producer;
		this.actors = actors;
		this.country = country;
		this.scores=scores;
		this.language = language;
		this.category = category;
		this.movie_year = movie_year;
	}
	public Movie(Integer id,String title, String description, String director, String producer, String actors,
			Country country, Language language, Set<Score> scores, Category category, String movie_year) {
		super();
		this.id=id;
		this.title = title;
		this.description = description;
		this.director = director;
		this.producer = producer;
		this.actors = actors;
		this.country = country;
		this.scores=scores;
		this.language = language;
		this.category = category;
		this.movie_year = movie_year;
	}
	@ManyToOne
	@JoinColumn(name = "movie_category_id", referencedColumnName = "category_id", nullable = false)
	private Category category;
	@Column(name = "movie_year", unique = false, nullable =true)
	private String movie_year;
	public int getId() {
		return id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public String getMovie_year() {
		return movie_year;
	}
	public void setMovie_year(String movie_year) {
		this.movie_year = movie_year;
	}
	
	public Movie() {
		super();
	}

	public void setId(Integer id) {
		this.id=id;
	}
    
	
}
