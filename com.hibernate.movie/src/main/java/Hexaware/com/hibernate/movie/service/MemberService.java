package Hexaware.com.hibernate.movie.service;

import java.util.List;
import java.util.Scanner;

import Hexaware.com.hibernate.movie.dao.MemberDao;
import Hexaware.com.hibernate.movie.model.Member;

public class MemberService {
	Scanner sc;
	MemberDao dao;
	public MemberService(Scanner sc)
	{
		this.sc=sc;
		this.dao=new MemberDao();
	}
	public void addMember() {
		System.out.println("Enter member Id:");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter member name:");
		String name=sc.nextLine();
		System.out.println("Enter movie Id");
		int movieId=Integer.parseInt(sc.nextLine());
		System.out.println("No of Tickets:");
		int tickets=Integer.parseInt(sc.nextLine());
		Member m=new Member(id,name,movieId,tickets);
		dao.createMember(m);
		System.out.println("Member Registered successfully.");
	}
	public void searchMemberById() {
		System.out.println("Enter member id to be searched:");
		int id=Integer.parseInt(sc.nextLine());
		Member m=dao.searchMember(id);
		System.out.println(m.toString());
	}
	public void deleteMember() {
		System.out.println("Enter member id to be deleted:");
		int id=Integer.parseInt(sc.nextLine());
		dao.deleteMember(id);
		
	}
	public void viewMembers() {
		List<Member> list=dao.viewAllMembers();
		for(Member m:list)
		{
			System.out.println(m.toString());
		}
	}
	
}
