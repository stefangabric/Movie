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
@Table(name = "category")
public class Category implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name", unique = false, nullable = false,length=30)
	private String name;
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "category")
	private Set<Movie> movies = new HashSet<Movie>();
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "category")
	private Set<User> users = new HashSet<User>();

	public void add(Movie m) {
		if (m.getCategory() != null){
			m.getCategory().getMovies().remove(m);
		}
		m.setCategory(this);
		movies.add(m);
	}
		

	public void remove(Movie m) {
		m.setCategory(null);
		movies.remove(m);
	}
	public void add(User m) {
		if (m.getCategory() != null){
			m.getCategory().getUsers().remove(m);
		}
		m.setCategory(this);
		users.add(m);
	}
		

	public void remove(User m) {
		m.setCategory(null);
		users.remove(m);
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public Category() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public Category(String name,Set<Movie> movies,Set<User> users) {
		super();
		this.users=users;
		this.name = name;
		this.movies = movies;
	}
	public Category(Integer id,String name,Set<Movie> movies,Set<User> users) {
		super();
		this.id=id;
		this.users=users;
		this.name = name;
		this.movies = movies;
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
