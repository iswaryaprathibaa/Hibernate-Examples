package Hexaware.com.library.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Hexaware.com.library.hibernate.model.Admin;
import Hexaware.com.library.hibernate.model.Book;
import Hexaware.com.library.hibernate.model.Member;

public class MemberDao {

	SessionFactory factory=null;
	Transaction tx=null;
	Session session = null;

    public MemberDao() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Member.class)
                .buildSessionFactory();
    }
	public void registerMember(Member m) {
		
		        try {
		            session = factory.openSession();
		            tx=session.beginTransaction();
		            session.save(m);
		            tx.commit();
		        } catch (Exception e) {
		            e.printStackTrace();
		        } 
		    }
	public boolean validateMember(int memId) {
		try {
            session = factory.openSession();
            Member m=session.get(Member.class, memId);
            if(m!=null)
            	return true;
        } catch (Exception e) {
            e.printStackTrace();
        } 

		return false;
	}
	
		public Member searchMemberById(int memId) {
		    Member member = null;
		    try {
		        session = factory.openSession();
		        member = session.get(Member.class, memId);

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }

		    return member;
		}
	
	
	

}
