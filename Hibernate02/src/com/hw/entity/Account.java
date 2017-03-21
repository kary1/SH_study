package com.hw.entity;

public class Account {
	
	private String id;
	private String name;
	private String pass;
	private double balance;	
	
	private Employee emp;

	public Account() {
	}

	public Account(String name, String pass, double balance) {
		this.name = name;
		this.pass = pass;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
}
