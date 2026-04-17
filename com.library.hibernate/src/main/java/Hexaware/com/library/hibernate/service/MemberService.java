package Hexaware.com.library.hibernate.service;

import Hexaware.com.library.hibernate.dao.BookDao;
import Hexaware.com.library.hibernate.dao.MemberDao;
import Hexaware.com.library.hibernate.model.Book;
import Hexaware.com.library.hibernate.model.Member;

public class MemberService {

	MemberDao dao=new MemberDao();
	BookDao bookdao=new BookDao();
	public void registerMember(Member m) {
		dao.registerMember(m);
	}
	public boolean validateMember(int memId) {
		if(dao.validateMember(memId))
			return true;
		return false;
	}
	public void issueBook(int memId, int bookId) {
	    Member member = dao.searchMemberById(memId);

	    if (member == null) {
	        System.out.println("Only registered members can issue books");
	        return;
	    }

	    Book book = bookdao.findBook(bookId);

	    if (book == null) {
	        System.out.println("Book not found");
	    } else if (book.getStatus().equalsIgnoreCase("Issued")) {
	        System.out.println("Book already issued");
	    } else {
	        book.setStatus("Issued");
	        bookdao.updateBook(book);
	        System.out.println("Book issued successfully");
	    }
	}
	public void returnBook(int bookId) {
	    Book book = bookdao.findBook(bookId);

	    if (book == null) {
	        System.out.println("Book not found");
	    } else if (book.getStatus().equalsIgnoreCase("Available")) {
	        System.out.println("Book is already available");
	    } else {
	        book.setStatus("Available");
	        bookdao.updateBook(book);
	        System.out.println("Book returned successfully");
	    }
	}
	public void searchBook(int bookId) {
	    Book book = bookdao.findBook(bookId);

	    if (book != null) {
	        System.out.println(book);
	    } else {
	        System.out.println("Book not found");
	    }
	}
}
