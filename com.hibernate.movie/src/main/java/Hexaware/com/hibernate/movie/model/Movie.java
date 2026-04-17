package Hexaware.com.hibernate.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieName;
	private double price;
	private int seats;
	public int getMovieId() {
		return movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public double getPrice() {
		return price;
	}
	public int getSeats() {
		return seats;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Movie(int movieId, String movieName, double price, int seats) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.price = price;
		this.seats = seats;
	}
	public Movie() {
		super();
	}
	@Override
	public String toString() {
		return "Member [movieId=" + movieId + ", movieName=" + movieName + ", price=" + price + ", seats=" + seats
				+ "]";
	}
	
}
