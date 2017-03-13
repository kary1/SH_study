package com.hw.entity;

import java.util.Set;

public class Student {
	
	private int id;
	private String name;
	private String gender;
	
	private Set<Course> courses;	//¿Î³Ì

	public Student() {
	}

	public Student(String name, String gender) {
		this.name = name;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
