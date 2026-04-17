package Hexaware.com.library.hibernate.service;

import Hexaware.com.library.hibernate.dao.AdminDao;
import Hexaware.com.library.hibernate.dao.BookDao;
import Hexaware.com.library.hibernate.model.Book;

public class AdminService {
	AdminDao dao=new AdminDao();
	BookDao bookdao=new BookDao();
	 public boolean adminLogin(int adminId, String password) {
	        return dao.validateAdmin(adminId, password);
	    }
	 public void addBook(Book book) {
		 bookdao.addBook(book);
		 System.out.println("Book added sucessfully.");
	 }
	 public void removeBook(int id) {
		bookdao.deleteBook(id);
	 }
	 public void updateBook(Book book) {
		bookdao.updateBook(book);
	 }
	 public void searchBook(int id) {
		Book b=bookdao.findBook(id);
		if (b != null) {
            System.out.println(b);
        } else {
            System.out.println("Book not found");
        }
	 }
}
