package dto;

import entity.Category;
import entity.Country;
import entity.Language;
import entity.Movie;

public class MovieDTO {
	private Integer id;
	private String title;
	private String description;
	private String director;
	private String producent;
	private String actors;
	private String movie_year;
	private Country country;
	private Language language ;
	private Category category;
	
	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieDTO(Movie m, Double avg) {
		System.out.println(m.getDescription());
		this.id = m.getId();
		this.title = m.getTitle();
		this.description = m.getDescription();
		this.director = m.getDirector();
		this.producent = m.getProducer();
		this.actors = m.getActors();
		this.movie_year  = m.getMovie_year();
		this.category = m.getCategory();
		this.country=m.getCountry();
		this.language = m.getLanguage();
		avgScore = avg;
	}
	
	public String getMovieDirector() {
		return director;
	}

	public void setMovieDirector(String movieDirector) {
		this.director = movieDirector;
	}

	public String getMovieProducent() {
		return producent;
	}

	public void setMovieProducent(String movieProducent) {
		this.producent = movieProducent;
	}

	public String getMovieActors() {
		return actors;
	}

	public void setMovieActors(String movieActors) {
		this.actors = movieActors;
	}

	public String getmovie_year() {
		return movie_year;
	}

	public void setmovie_year(String movie_year) {
		this.movie_year = movie_year;
	}

	public Country getCountry_id() {
		return country;
	}

	public void setCountry_id(Country country) {
		this.country = country;
	}

	public Language getLanguage_id() {
		return language;
	}

	public void setLanguage_id(Language language) {
		this.language = language;
	}

	public Category getCategory_id() {
		return category;
	}

	public void setCategory_id(Category category) {
		this.category = category;
	}

	private Double avgScore;
	
	
	
	public Double getAvgScore() {
		return avgScore;
	}
	
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}
