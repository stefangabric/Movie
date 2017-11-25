package entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQuery(name = "findUserSaKorisnickimImenomILozinkom",
query = "SELECT k FROM User k WHERE k.user_name like :user_name"
		+ " AND k.user_pass LIKE :user_pass")

@Entity
@Table(name = "user")

public class User implements Serializable {

	private static final long serialVersionUID = 3770759786667844735L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "fname", unique = false,length=30)
	private String fname;

	@Column(name = "lname", unique = false,length=30)
	private String lname;

	@Column(name = "user_name", unique = true,length=10)
	private String username;

	@Column(name = "user_pass", nullable = false, unique = false,length=10)
	private String pass;
	@ManyToOne
	@JoinColumn(name = "user_category_id", referencedColumnName = "category_id", nullable = true)
	private Category category;
	
	public Integer getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User(String fname, String lname, String username, String pass, Category category) {
		super();
		
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pass = pass;
		this.category = category;
		}

	public User() {
	}

	public User(Integer id,String fname, String lname, String username, String pass, Category category) {
		super();
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pass = pass;
		this.category = category;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}


	

}
