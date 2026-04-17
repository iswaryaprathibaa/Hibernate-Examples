package Hexaware.com.hibernate.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {
	@Id
	private int memId;
	private String memName;
	private int movieId;
	private int tickets;
	public int getMemId() {
		return memId;
	}
	public String getMemName() {
		return memName;
	}
	public int getMovieId() {
		return movieId;
	}
	public int getTickets() {
		return tickets;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public Member(int memId, String memName, int movieId, int tickets) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.movieId = movieId;
		this.tickets = tickets;
	}
	public Member() {
		super();
	}
	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memName=" + memName + ", movieId=" + movieId + ", tickets=" + tickets
				+ "]";
	}
	
}
