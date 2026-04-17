package Hexaware.com.library.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Hexaware.com.library.hibernate.model.Admin;
import Hexaware.com.library.hibernate.model.Book;
import Hexaware.com.library.hibernate.model.Member;

public class AdminDao {

	SessionFactory factory=null;
	Transaction tx=null;
	Session session = null;

    public AdminDao() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Member.class)
                .buildSessionFactory();
    }

    public boolean validateAdmin(int adminId, String password) {
        
        try {
            session = factory.openSession();

            Admin admin = session.get(Admin.class, adminId);
            
            if (admin != null && admin.getAdminPassword().equals(password)) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
}
}
