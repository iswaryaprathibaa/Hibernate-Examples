package Hexaware.com.hibernate.movie.service;

import java.util.List;
import java.util.Scanner;

import Hexaware.com.hibernate.movie.dao.MovieDao;
import Hexaware.com.hibernate.movie.model.Movie;

public class MovieService {
	private Scanner sc;
	private MovieDao dao;
	public MovieService(Scanner sc)
	{
		this.sc=sc;
		this.dao=new MovieDao();
	}

	public void addMovie() {
		System.out.println("Enter movie Id:");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter movie name:");
		String name=sc.nextLine();
		System.out.println("Enter price");
		double price=Double.parseDouble(sc.nextLine());
		System.out.println("Enter no.of seats:");
		int seats=Integer.parseInt(sc.nextLine());
		Movie m=new Movie(id,name,price,seats);
		dao.createMovie(m);
		System.out.println("Movie created successfully");
	}

	public void updateMovie() {
		System.out.println("Enter id of the movie to be updated:");
		int id=sc.nextInt();
		System.out.println("Enter the updated price:");
		double price=Double.parseDouble(sc.nextLine());
		dao.updateMovie(id,price);
	}

	public void searchMovie() {
		System.out.println("Enter id to be searched:");
		int id=sc.nextInt();
		Movie m=dao.findMovie(id);
		if(m!=null)
		{
			System.out.println(m.toString());
		}
		else {
			System.out.println("Movie not found");
		}
	}

	public void deleteMovie() {
		System.out.println("Enter id to be deleted:");
		int id=Integer.parseInt(sc.nextLine());
		dao.RemoveMovie(id);
	}

	public void viewMovies() {
		List<Movie> list=dao.showAllMovies();
		for(Movie m:list)
		{
			System.out.println(m.toString());
		}
	}
	
}
