package Hexaware.com.hibernate.movie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Hexaware.com.hibernate.movie.model.Member;
import Hexaware.com.hibernate.movie.model.Movie;

public class MovieDao {
	SessionFactory factory=null;
	Transaction tx=null;
	Session session = null;
    public MovieDao() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class).addAnnotatedClass(Member.class)
                .buildSessionFactory();
    }
	@SuppressWarnings("deprecation")
	public void createMovie(Movie m) {
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		session.save(m);
		tx.commit();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updateMovie(int id, double price) {
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Movie> q=session.createQuery("update Movie set price=:price where movieId=:id",Movie.class);
			q.setParameter("price", price);
			q.setParameter("pid", id);
			  int c=q.executeUpdate();
			  tx.commit();
			   if(c>0)
			   {
				   System.out.println("Movie Updated successfully");
				   
			   }
			   else
			   {
				   System.out.println("Movie not found");
			   }
			    
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}
	public Movie findMovie(int id) {
		Movie m=null;
	
		try {
			session=factory.openSession();
			
			Query<Movie> q=session.createQuery("from Movie where movieId=:id",Movie.class);
			q.setParameter("pid", id);
			m=q.uniqueResult();
			    
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return m;
	}
	public void RemoveMovie(int id) {
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Movie> q=session.createQuery("delete from Movie where movieId=:id",Movie.class);
			q.setParameter("pid", id);
			int c=q.executeUpdate();
			tx.commit();
			if(c>0)
			{
				System.out.println("Movie deleted succesfully");
				
			}
			else {
				System.out.println("Movie not found");
			}
			    
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public List<Movie> showAllMovies() {
		List<Movie> l=null;
		try {
			session=factory.openSession();
			
			Query<Movie> q=session.createQuery("from Movie ",Movie.class);
			l=q.list();
			    
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return l;
	}
	
}
