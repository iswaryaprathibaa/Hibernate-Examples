package Hexaware.com.product.Hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
	
    @SuppressWarnings("rawtypes")
	public static void main( String[] args )
    {
    	SessionFactory factory=null;
 	   	Session session=null;
 	   	Transaction tx=null;
 	
 	   	try {
 	   		factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
 	   		session = factory.openSession();
	 	   	Scanner sc=new Scanner(System.in);
	    	int ch;
	    	do {
	    		System.out.println("==========Menu=========");
	    		System.out.println("1.Add a new Product");
	    		System.out.println("2.Update Price");
	    		System.out.println("3.Search Product");
	    		System.out.println("4.Delete Product");
	    		System.out.println("5.Show all products");
	    		System.out.println("6.page-wise display");
	    		System.out.println("7.Exit");
	    		System.out.println("Enter your choice:");
	    		ch=sc.nextInt();
	    		switch(ch) {
		    		case 1:
		    		{
		    			System.out.println("Enter product ID:");
		    			int id=sc.nextInt();
		    			sc.nextLine();
		    			System.out.println("Enter product Name:");
		    			String name=sc.nextLine();
		    			System.out.println("Enter price:");
		    			double price=sc.nextDouble();
		    			tx=session.beginTransaction();
		    			 Query q = session.createNativeQuery(
	                                "INSERT INTO ProductData (productId, productName, price) VALUES (?, ?, ?)"
	                        );
	                        q.setParameter(1, id);
	                        q.setParameter(2, name);
	                        q.setParameter(3, price);

	                        int rows = q.executeUpdate();
	                        tx.commit();

	                        if (rows > 0) {
	                            System.out.println("Product inserted successfully!");
	                        } else {
	                            System.out.println("Insert failed!");
	                        }
//		    			Product p=new Product(id,name,price);
//		    			tx=session.beginTransaction();
//		    			session.save(p);
//		    			tx.commit();
		    			break;
		    		}
		    		case 2:
		    		{
		    			System.out.println("Enter id to update:");
		    			int uid=sc.nextInt();
		    			System.out.println("Enter updated price:");
		    			double uprice=sc.nextDouble();
		    			tx=session.beginTransaction();
//		    			Query q=session.createQuery("update Product set price=:price where productId=:pid");
//		    			q.setParameter("price", uprice);
//		    			q.setParameter("pid", uid);
//		    			  int c=q.executeUpdate();
//		    			    
//		    			    System.out.println(c);
//		    			    
//		    			    tx.commit();
		    			 Query q = session.createNativeQuery(
	                                "UPDATE ProductData SET price = ? WHERE productId = ?"
	                        );
	                        q.setParameter(1, uprice);
	                        q.setParameter(2, uid);

	                        q.executeUpdate();
	                        tx.commit();
		    			break;
		    		}
		    		case 3:
		    		{
		    			System.out.println("Enter id to be searched:");
		    			 int id=sc.nextInt();
//		    			
//		    			
//		    			 Query<Product> q1=session.createQuery("from Product where productId=:id ",Product.class);
//		    			
//		    			
//		    			    q1.setParameter("id", id);
//		    			    
//		    			    Product p=q1.uniqueResult();
//		    			    
//		    			    System.out.println(p.toString());
		    			Query<Product> q=session.createNativeQuery("select * from Productdata where productId=?",Product.class);
		    			
		    			
		    			 q.setParameter(1, 102);
		    			
		    		
		    	       Product p=  q.uniqueResult()	;	
		    	       
		    	       System.out.println(p.toString());
		    	 
		    			    break;
		    		}
		    		case 4:
		    		{

		    			System.out.println("Enter id to delete:");
		    			int id=sc.nextInt();
		    			tx=session.beginTransaction();
//		    			 Query q1=session.createQuery("delete from Product where productId=:id ");
//		    			
//		    			
//		    			    q1.setParameter("id", id);
//		    			    int c=q1.executeUpdate();
//		    			    tx.commit();
//		    			    if (c > 0) {
//		    			        System.out.println(c + " row deleted");
//		    			    } else {
//		    			        System.out.println("Product not found");
//		    			    }
		    			 Query q = session.createNativeQuery(
	                                "DELETE FROM ProductData WHERE productId = ?"
	                        );
	                        q.setParameter(1, id);

	                        q.executeUpdate();
	                        tx.commit();
		    			break;
		    		}
		    		case 5:
		    		{
		    			System.out.println("Saved products.......");
//		    			Query<Product> q=session.createQuery("from Product", Product.class);
////		    			Query<Product> q=session.createQuery("from Product order by productId desc", Product.class);for displaying in asc or desc order
////		    			q.setFirstResult(2);starting position
////		    			q.setMaxResults(5); pagination;max elements
//		    			List<Product> list=q.list();
//		    			for(Product p:list)
//		    			{
//		    				System.out.println(p.toString());
//		    			}
		    			 Query<Product> q=session.createNativeQuery("select * from Productdata",Product.class);
		    				
		    				
		    		 	 List<Product> list= q.list();
		    		 	
		    		 	
		    		 	 for(Product i : list)
		    		 	 {
		    		 		 System.out.println(i.toString());
		    		 	 }
		    			break;
		    		}
		    		case 6:
		    		{
		    			System.out.println("Enter page no:");
		    			int pageNo=sc.nextInt();
		    			if(pageNo<=0)
		    			{
		    				System.out.println("Invalid page number.......");
		    			}
		    			int size=3;
		    			Query<Product> q=session.createQuery("from Product", Product.class);
		    			q.setFirstResult((pageNo - 1) * size);
		    			q.setMaxResults(3);
		    			
		    			List<Product> list=q.list();
		    			for(Product p:list)
		    			{
		    				System.out.println(p.toString());
		    			}
		    			break;
		    		}
		    		case 7:
		    		{
		    			break;
		    		}
	    		}
	    	}while(ch!=7);
 	   	}
 	   	catch(Exception e)
 	   	{
 	   		System.out.println(e.getMessage());
 	   	}
    	
    	
        
    }
	
}
