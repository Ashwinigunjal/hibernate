package com.demo.jdbc;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stddata")
public class Student {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name ="id")
	int id;
	
	
	@Column(name = "name")
	private String name;


	@Column(name = "lname")
	private String lname;

	
	@Column(name = "email")
	private String email;
	
	public Student(){
		
	}

	public Student(String name, String lname, String email) {
		super();
		this.name = name;
		this.lname = lname;
		this.email = email;
		System.out.println("inside constructor");
	}

	
	
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", lname=" + lname + ", email=" + email + "]";
	}



	
	
	
}
