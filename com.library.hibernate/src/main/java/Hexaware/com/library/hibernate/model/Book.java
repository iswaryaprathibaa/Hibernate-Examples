package Hexaware.com.library.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	private int bookId;
	private String bookName;
	private String authorName;
	private double price;
	private String status;
	public int getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public double getPrice() {
		return price;
	}
	public String getStatus() {
		return status;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Book(int bookId, String bookName, String authorName, double price, String status) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.status = status;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price
				+ ", status=" + status + "]";
	}
	
}
