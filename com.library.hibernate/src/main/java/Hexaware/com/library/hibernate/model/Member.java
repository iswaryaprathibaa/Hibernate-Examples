package Hexaware.com.library.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {
	@Id
	private int memId;
	private String memName;
	private String phoneNumber;
	public int getMemId() {
		return memId;
	}
	public String getMemName() {
		return memName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Member(int memId, String memName, String phoneNumber) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.phoneNumber = phoneNumber;
	}
	public Member() {
		super();
	}
	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memName=" + memName + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
