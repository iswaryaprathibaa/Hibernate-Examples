package Hexaware.com.Hibernatelogin;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
  @SuppressWarnings("deprecation")
public static void main(String[] args) {
	  	SessionFactory factory=null;
	   	Session session=null;
	   	Transaction tx=null;
	   	try {
	   		factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Login.class).buildSessionFactory();
	   		session = factory.openSession();
	 	   	Scanner sc=new Scanner(System.in);
	    	int ch;
	    	do {
	    			System.out.println("=============Menu===========");
	    			System.out.println("1. Sign Up (New User Registration)");
	                System.out.println("2. Sign In");
	                System.out.println("3. Forgot Password");
	                System.out.println("4. Update Password");
	                System.out.println("5. Search User");
	                System.out.println("6. Delete User Account");
	                System.out.println("7. Exit");
	                System.out.print("Enter your choice: ");
	                ch=sc.nextInt();
	                switch(ch)
	                {
	                case 1:
		                {
		                	System.out.println("Enter user id:");
		                	int id=sc.nextInt();sc.nextLine();
		                	System.out.println("Enter user name:");
		                	String name=sc.nextLine();
		                	System.out.println("Enter email");
		                	String email=sc.nextLine();
		                	System.out.println("Enter Password:");
		                	String pswd=sc.nextLine();
		                	Login obj=new Login(id,name,email,pswd);
		                	tx=session.beginTransaction();
		                	session.save(obj);
		                	tx.commit();
		                	break;
		                }
	               
	                case 2: {
	                    System.out.print("Enter User ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();

	                    System.out.print("Enter Password: ");
	                    String pass = sc.nextLine();

	                    Login l = session.get(Login.class, id);

	                    if (l != null && l.getPassword().equals(pass)) {
	                        System.out.println("Sign In Successful");
	                        System.out.println("Welcome " + l.getUserName());
	                    } else {
	                        System.out.println("Invalid User ID or Password");
	                    }
	                    break;
	                }
	                
	                case 3: {
	                    System.out.print("Enter User ID: ");
	                    int id = sc.nextInt();

	                    Login obj = session.get(Login.class, id);

	                    if (obj != null) {
	                        System.out.println("Your password is: " + obj.getPassword());
	                    } else {
	                        System.out.println("User not found");
	                    }
	                    break;
	                }
	                
	                case 4:
	                {
	                	System.out.println("Enter user id to update:");
	                	int uid=sc.nextInt();sc.nextLine();
	                	Login obj=session.get(Login.class, uid);
	                	if(obj!=null)
	                	{
	                		System.out.println("enter updated password:");
	                		String pass=sc.nextLine();
	                		tx=session.beginTransaction();
	                		obj.setPassword(pass);
	                		session.update(obj);
	                		tx.commit();
	                	}
	                	else {
	                		System.out.println();
	                	}
	                	break;
	                }
	                case 5:
	                {
	                	System.out.println("Enter user id to be searched:");
	                	int uid=sc.nextInt();sc.nextLine();
	                	System.out.println("Enter password:");
	                	String pass=sc.nextLine();
	                	Login obj=session.get(Login.class, uid);
	                	if(obj!=null && obj.getPassword().equals(pass))
	                	{
	                		System.out.println("user found");
	                		System.out.println(obj);
	                	}
	                	else {
	                		System.out.println("User not found");
	                	}
	                	break;
	                }
	                case 6:
	                {
	                	System.out.print("Enter user id to delete: ");
	                    int id = sc.nextInt();
	                    Login l = session.get(Login.class, id);
	                    if (l != null) {
	                        tx = session.beginTransaction();
	                        session.delete(l);
	                        tx.commit();
	                        System.out.println("User account deleted successfully");
	                    } else {
	                        System.out.println("User not found");
	                    }
	                    break;
	                }
	                case 7:
	                {
	                	System.exit(0);
	                	break;
	                }
	                }
	    	}while(ch!=7);
	    	sc.close();
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.println(e.getMessage());
	   	}
	   
  }
}
