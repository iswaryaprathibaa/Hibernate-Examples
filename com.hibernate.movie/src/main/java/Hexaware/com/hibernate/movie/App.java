package Hexaware.com.hibernate.movie;

import java.util.Scanner;

import Hexaware.com.hibernate.movie.service.BookingService;
import Hexaware.com.hibernate.movie.service.MemberService;
import Hexaware.com.hibernate.movie.service.MovieService;

public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	Scanner sc=new Scanner(System.in);
    	MovieService serv=new MovieService(sc);
    	MemberService memserv=new MemberService(sc);
    	BookingService bookserv=new BookingService(sc);
    	int ch;
    	int moviech,memch,bookch;
    	do {
    		System.out.println("1.Movie Operations");
    		System.out.println("2.Member Operations");
    		System.out.println("3.Booking Operations");
    		System.out.println("4.Exit");
    		ch=sc.nextInt();
    		switch(ch)
    		{
	    		case 1:
	    		{
	    			
	    			do {
	    				System.out.println("========Movie Operations======");
	    				System.out.println("1.Add movie");
	    				System.out.println("2.update price");
	    				System.out.println("3.Search movie by Id");
	    				System.out.println("4.Delete movie");
	    				System.out.println("5.Show all movies");
	    				System.out.println("6.Exit");
	    				moviech=sc.nextInt();
	    				switch(moviech)
	    				{
	    				case 1:
	    				{
	    					serv.addMovie();
	    					break;
	    				}
	    				case 2:
	    				{
	    					serv.updateMovie();
	    					break;
	    				}
	    				case 3:
	    				{
	    					serv.searchMovie();
	    					break;
	    				}
	    				case 4:
	    				{
	    					serv.deleteMovie();
	    					break;
	    				}
	    				case 5:
	    				{
	    					serv.viewMovies();
	    					break;
	    				}
	    				case 6:
	    				{
	    					System.out.println("Exiting Movie Operations.....");
	    					break;
	    				}
	    				}
	    			}while(moviech!=6);
	    			break;
	    		}
	    		case 2:
	    		{
	    			do {
	    				System.out.println("========Member Operations======");
	    				System.out.println("1.Add member");
	    				System.out.println("2.Search member by Id");
	    				System.out.println("3.Delete members");
	    				System.out.println("4.Show all members");
	    				System.out.println("5.logout");
	    				memch=sc.nextInt();
	    				switch(memch)
	    				{
	    				case 1:
	    				{
	    					memserv.addMember();
	    					break;
	    				}
	    				case 2:
	    				{
	    					memserv.searchMemberById();
	    					break;
	    				}
	    				case 3:
	    				{
	    					memserv.deleteMember();
	    					break;
	    				}
	    				case 4:
	    				{
	    					memserv.viewMembers();
	    					break;
	    				}
	    				case 5:
	    				{
	    					System.out.println("exiting......");
	    					break;
	    				}
	    				}
	    			}while(memch!=5);
	    			break;
	    		}
	    		case 3:
	    		{
	    			do {
	    				System.out.println("========Booking Operations======");
	    				System.out.println("1.Book tickets");
	    				System.out.println("2.cancel tickets");
	    				System.out.println("3.Show Booking details");
	    				System.out.println("4.Total Amount");
	    				System.out.println("5.logout");
	    				bookch=sc.nextInt();
	    				switch(bookch)
	    				{
	    				case 1:
	    	            {
	    	                bookserv.bookTicket();
	    	                break;
	    	            }
	    	            case 2:
	    	            {
	    	                bookserv.cancelTicket();
	    	                break;
	    	            }
	    	            case 3:
	    	            {
	    	                bookserv.showBookingDetails();
	    	                break;
	    	            }
	    	            case 4:
	    	            {
	    	                bookserv.totalAmount();
	    	                break;
	    	            }
	    	            case 5:
	    	            {
	    	                System.out.println("Exiting Booking Operations...");
	    	                break;
	    	            }
	    				}
	    			}while(bookch!=5);
	    			break;
	    		}
	    		case 4:
	    		{
	    			System.out.println("Exiting...........");
	    			break;
	    		}
    		}
    	}while(ch!=4);
    }
}
