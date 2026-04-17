package Hexaware.com.library.hibernate;

import java.util.Scanner;

import Hexaware.com.library.hibernate.model.Book;
import Hexaware.com.library.hibernate.model.Member;
import Hexaware.com.library.hibernate.service.AdminService;
import Hexaware.com.library.hibernate.service.MemberService;

public class App {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  AdminService serv=new AdminService();
	  MemberService memserv=new MemberService();
	  int ch;
	  do {
		  System.out.println("=====Main Menu======");
          System.out.println("1. Admin login");
          System.out.println("2. Member login");
          System.out.println("3. New member Registration");
          System.out.println("4. exit");
          System.out.print("Enter choice: ");
          ch = sc.nextInt();
          switch(ch)
          {
	          case 1:
	          {
	        	  System.out.print("Enter admin Id:");
	        	  int adminid= sc.nextInt();sc.nextLine();

	        	   System.out.print("Enter Password: ");
	        	   String pass = sc.nextLine();

	        	    if (serv.adminLogin(adminid, pass)) {
	        	        System.out.println("Admin login successful.");
	        	        int adminch;
	        	        do {
		        	        	System.out.println("======ADMIN MENU======");
		        	        	System.out.println("1. Add Book");
	                            System.out.println("2. Remove Book");
	                            System.out.println("3. Update Book");
	                            System.out.println("4. Search Book");
	                            System.out.println("5. Exit");
	                            System.out.print("Enter choice: ");
	                            adminch = sc.nextInt();
	                            
	                            switch(adminch)
	                            {
		                            case 1:
		                            {
		                            	
		                            	 System.out.print("Enter Book ID: ");
		                                  int id = sc.nextInt();sc.nextLine();
		                                  System.out.print("Enter Book Name: ");
		                                  String name = sc.nextLine();
		                                  System.out.print("Enter Author Name: ");
		                                  String author = sc.nextLine();
		                                  System.out.print("Enter Price: ");
		                                  double price = sc.nextDouble();
		                                  String status="Available";
		                                   Book book = new Book(id, name, author, price,status);
		                                    serv.addBook(book);
		                                    break;
		                            }
		                            case 2:
		                            {
		                            	System.out.println("Enter book id to remove:");
		                            	int id=sc.nextInt();
		                            	serv.removeBook(id);
		                            	break;
		                            }
		                            case 3:
		                            {
		                            	System.out.println("Enter book id to update:");
		                            	int id=sc.nextInt();sc.nextLine();
		                            	System.out.print("Enter Book Name: ");
		                                String name = sc.nextLine();
		                                System.out.print("Enter Author Name: ");
		                                String author = sc.nextLine();
		                                System.out.print("Enter Price: ");
		                                double price = sc.nextDouble();sc.nextLine();
		                                System.out.println("Enter status:");
		                                String status=sc.nextLine();
		                                   Book book = new Book(id, name, author, price,status);
		                            	
		                            	serv.updateBook(book);
		                            	break;
		                            }
		                            case 4:
		                            {
		                            	System.out.println("Enter book id to be searched");
		                            	int id=sc.nextInt();
		                            	serv.searchBook(id);
		                            	break;
		                            }
		                            case 5:
		                            {
		                            	System.out.println("Exiting admin Login.....");
		                            	break;
		                            }
	                            }

	        	        }while(adminch!=5);
	        	    }
	        	    else {
	        	        System.out.println("Invalid credentials");
	        	    }
	        	    break;
	          		}
		          case 2:
		          {
		        	  System.out.println("Enter member id to login:");
		        	  int memId=sc.nextInt();
		        	  if(memserv.validateMember(memId))
		        	  {
		        		  System.out.println("Member login successfull.");
		        		  int memch;
		        		  do{
		        			  System.out.println("======MEMBER MENU======");
		        	            System.out.println("1. Issue Book");
		        	            System.out.println("2. Return Book");
		        	            System.out.println("3. Search Book");		        	           
		        	            System.out.println("4. Exit");
		        	            System.out.print("Enter choice: ");
		        	            memch = sc.nextInt();
		        	            switch(memch)
		        	            {
			        	            case 1:
			        	            {
			        	            	System.out.println("Enter Book Id to issue:");
			        	                int bookId = sc.nextInt();
			        	                memserv.issueBook(memId, bookId);
			        	                break;
			        	            }
			        	            case 2:
			        	            {
			        	            	System.out.println("Enter book id to be returned:");
			        	            	int id=sc.nextInt();
			        	            	memserv.returnBook(id);
			        	            	break;
			        	            }
			        	            case 3:
			        	            {
			        	            	System.out.println("Enter book id to be searched:");
			        	            	int id=sc.nextInt();
			        	            	memserv.searchBook(id);
			        	            	break;
			        	            }
			        	            case 4:
			        	            {
			        	            	System.out.println("Exiting member login....");
			        	            	break;
			        	            }
		        	            }
		        		  }while(memch!=4);
		        	  }
		        	  else {
		        		  System.out.println("Member not found");
		        	  }
		        	  break;
		          }
		          case 3:
			          {
			        	  System.out.println("=====MEMBER REGISTRATION=====");
			        	  System.out.println("enter Member id:");
			        	  int memId=sc.nextInt();sc.nextLine();
			        	  System.out.println("Enter Member name:");
			        	  String memName=sc.nextLine();
			        	  System.out.println("Enter phone Number:");
			        	  String ph=sc.nextLine();
			        	  Member m=new Member(memId,memName,ph);
			        	  memserv.registerMember(m);
			        	  break;
			        	  
			          }
		          case 4:
			          {
			        	 System.out.println("Exiting Library Management System");
			        	 System.exit(0); 
			          }
		          
	  }
  }while(ch!=4);
	  sc.close();
}
}
