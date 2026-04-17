package Hexaware.com.library.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Hexaware.com.library.hibernate.model.Admin;
import Hexaware.com.library.hibernate.model.Book;
import Hexaware.com.library.hibernate.model.Member;

public class BookDao {
	SessionFactory factory=null;
	Transaction tx=null;
	Session session = null;
    public BookDao() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Member.class)
                .buildSessionFactory();
    }
    public void addBook(Book book) {
        try {
            session = factory.openSession();
            tx=session.beginTransaction();
            session.save(book);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
	public void deleteBook(int id) {
		try {
			session=factory.openSession();
			Book b=session.get(Book.class, id);
			 if (b != null) {
				 	tx=session.beginTransaction();
	                session.delete(b);;
	                tx.commit();
	                System.out.println("Book removed successfully");
	            } else {
	                System.out.println("Book not found");
	            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updateBook(Book book) {
		try {
			session=factory.openSession();
			 session = factory.openSession();
		        tx=session.beginTransaction();

		       session.update(book);

		        tx.commit();
		        System.out.println("Book updated successfully");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Book findBook(int id) {
		Book b=null;
		try {
			session=factory.openSession();
			b=session.get(Book.class, id);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	

}
