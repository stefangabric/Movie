package entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = -7070493936527350889L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "country_id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name", unique = false, nullable = false,length=30)
	private String name;
	
	public Integer getId() {
		return id;
	}
	public Country() {
		super();
	}

	public Country(String name) {
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
