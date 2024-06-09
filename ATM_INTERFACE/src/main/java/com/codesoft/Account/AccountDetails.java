package com.codesoft.Account;

import com.codesoft.users.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true,nullable = false,updatable = false)
	private long accountNumber;
	private String IFSC;
	private double balance;
	@OneToOne(mappedBy = "accountDetails")
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getIFSC() {
		return IFSC;
	}
	
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountDetails(long id, long accountNumber, String iFSC, double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		IFSC = iFSC;
		this.balance = balance;
	}
	
	public AccountDetails() {
		// TODO Auto-generated constructor stub
	}
	
}
