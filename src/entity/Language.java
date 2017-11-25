package entity;


import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language implements Serializable {

	private static final long serialVersionUID = -7070493936527350889L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "language_id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name", unique = false, nullable = false,length=30)
	private String name;


	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "language")
	private Set<Movie> movies = new HashSet<Movie>();

	public void add(Movie m) {
		if (m.getLanguage() != null){
			m.getLanguage().getMovies().remove(m);
		}
		m.setLanguage(this);
		movies.add(m);
	}
		

	public void remove(Movie m) {
		m.setCategory(null);
		movies.remove(m);
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Language() {
		super();
	}

	public Language(String name) {
		super();
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}


