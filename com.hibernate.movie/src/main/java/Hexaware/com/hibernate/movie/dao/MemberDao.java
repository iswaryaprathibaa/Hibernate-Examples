package Hexaware.com.hibernate.movie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Hexaware.com.hibernate.movie.model.Member;
import Hexaware.com.hibernate.movie.model.Movie;

public class MemberDao {
	SessionFactory factory=null;
	Transaction tx=null;
	Session session = null;
    public MemberDao() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class).addAnnotatedClass(Member.class)
                .buildSessionFactory();
    }
	public void createMember(Member m) {
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.save(m);
			tx.commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public Member searchMember(int id) {
		Member m=null;
		try {
			session=factory.openSession();
			Query<Member> q=session.createQuery("from Member where memId=:id",Member.class);
			q.setParameter("id", id);
			m=q.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	public void deleteMember(int id) {
		try {
			session=factory.openSession();
			
			Query<Movie> q=session.createQuery("from Member where memId=:id",Movie.class);
			q.setParameter("pid", id);
			int c=q.executeUpdate();
			if(c>0)
			{
				System.out.println("Member deleted succesfully");
			}
			else {
				System.out.println("Member not found");
			}
			    
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	public List<Member> viewAllMembers() {
		List<Member> l=null;
		try {
			session=factory.openSession();
			Query<Member> q=session.createQuery("from Member",Member.class);
			 l=q.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
		
	}
}
