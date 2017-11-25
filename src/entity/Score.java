package entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(
	    name="getScoresFor",
	    query="SELECT k FROM Score k WHERE k.movie = ?1")

@Entity
@Table(name = "score")
public class Score implements Serializable{
	
	private static final long serialVersionUID = 7033232793607903812L;

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "score_id", unique = true, nullable = false)
	private Integer scoreID;
	
	@Column(name = "score_score", unique = false, nullable = false)
	private Integer score;
	
	@Column(name = "score_date", unique = false)
	private Date date;
	
	
	
	public Integer getScoreID() {
		return scoreID;
	}
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne	
	@JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false)
	private Movie movie;

	
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Score(Integer score, Date date2,Movie movie) {
		super();
		this.score = score;
		this.date = date2;
		this.movie=movie;
	}
	
	public void setScoreID(Integer scoreID) {
		this.scoreID = scoreID;
	}

	public Score(){
		super();
	}
	
	@Override
	public String toString() {
		return "Score [scoreID=" + scoreID + ", score=" + score + ", date=" + date + ", movie ="+ movie + "]";
	}
	
	
	
	
}

