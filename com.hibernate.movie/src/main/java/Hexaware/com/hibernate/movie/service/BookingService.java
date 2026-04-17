package Hexaware.com.hibernate.movie.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Hexaware.com.hibernate.movie.model.Member;
import Hexaware.com.hibernate.movie.model.Movie;

public class BookingService {
	private Scanner sc;
	
	SessionFactory factory=null;
	Transaction tx=null;
	Session session = null;
    public BookingService(Scanner sc) {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class).addAnnotatedClass(Member.class)
                .buildSessionFactory();
        this.sc=sc;
    }
    public void bookTicket() {
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            System.out.println("Enter Member Id:");
            int memberId = sc.nextInt();

            System.out.println("Enter Movie Id:");
            int movieId = sc.nextInt();

            System.out.println("Enter number of tickets to book:");
            int reqTickets = sc.nextInt();

            // Get Member
            Member member = session.get(Member.class, memberId);
            if (member == null) {
                System.out.println("Member not found");
                tx.rollback();
                return;
            }

            // Get Movie
            Movie movie = session.get(Movie.class, movieId);
            if (movie == null) {
                System.out.println("Movie not found");
                tx.rollback();
                return;
            }

            // Check seats
            if (movie.getSeats() >= reqTickets) {
                movie.setSeats(movie.getSeats() - reqTickets);
                member.setMovieId(movieId);
                member.setTickets(member.getTickets() + reqTickets);

                session.update(movie);
                session.update(member);

                tx.commit();
                System.out.println("Ticket booked successfully");
            } else {
                System.out.println("Not enough seats available");
                tx.rollback();
            }

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }

    // 2. Cancel Ticket
    public void cancelTicket() {
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            System.out.println("Enter Member Id:");
            int memberId = sc.nextInt();

            System.out.println("Enter number of tickets to cancel:");
            int cancelTickets = sc.nextInt();

            // Get Member
            Member member = session.get(Member.class, memberId);
            if (member == null) {
                System.out.println("Member not found");
                tx.rollback();
                return;
            }

            // Get Movie using member's booked movieId
            Movie movie = session.get(Movie.class, member.getMovieId());
            if (movie == null) {
                System.out.println("Movie not found for this booking");
                tx.rollback();
                return;
            }

            // Check if member has enough tickets
            if (member.getTickets() >= cancelTickets) {
                member.setTickets(member.getTickets() - cancelTickets);
                movie.setSeats(movie.getSeats() + cancelTickets);

                // Optional: if all tickets cancelled, reset movieId
                if (member.getTickets() == 0) {
                    member.setMovieId(0);
                }

                session.update(member);
                session.update(movie);

                tx.commit();
                System.out.println("Ticket cancelled successfully");
            } else {
                System.out.println("Invalid cancel count");
                tx.rollback();
            }

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }

    // 3. Show Booking Details
    public void showBookingDetails() {
        try {
            session = factory.openSession();

            System.out.println("Enter Member Id:");
            int memberId = sc.nextInt();

            Query<Object[]> q = session.createQuery(
                    "select mem.memberId, mem.memberName, mov.movieName, mem.tickets " +
                    "from Member mem, Movie mov " +
                    "where mem.movieId = mov.movieId and mem.memberId = :id",
                    Object[].class);

            q.setParameter("id", memberId);

            Object[] row = q.uniqueResult();

            if (row != null) {
                System.out.println("===== Booking Details =====");
                System.out.println("Member Id   : " + row[0]);
                System.out.println("Member Name : " + row[1]);
                System.out.println("Movie Name  : " + row[2]);
                System.out.println("Tickets     : " + row[3]);
            } else {
                System.out.println("No booking details found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }

    // 4. Total Amount
    public void totalAmount() {
        try {
            session = factory.openSession();

            System.out.println("Enter Member Id:");
            int memberId = sc.nextInt();

            Query<Object[]> q = session.createQuery(
                    "select mem.memberName, mov.movieName, mem.tickets, mov.price, (mem.tickets * mov.price) " +
                    "from Member mem, Movie mov " +
                    "where mem.movieId = mov.movieId and mem.memberId = :id",
                    Object[].class);

            q.setParameter("id", memberId);

            Object[] row = q.uniqueResult();

            if (row != null) {
                System.out.println("===== Total Amount Details =====");
                System.out.println("Member Name   : " + row[0]);
                System.out.println("Movie Name    : " + row[1]);
                System.out.println("Tickets       : " + row[2]);
                System.out.println("Price/Ticket  : " + row[3]);
                System.out.println("Total Amount  : " + row[4]);
            } else {
                System.out.println("No booking found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }
}

