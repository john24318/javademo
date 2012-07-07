package com.oreilly.tiger.ch03;

public class Student {

	private String firstName;
	private String lastName;
	private Grade grade;

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return new StringBuffer(firstName).append(" ").append(lastName).toString();
	}

	public void assignGrade(Grade grade) {
		this.grade = grade;
	}

	public Grade getGrade() {
		return grade;
	}
}