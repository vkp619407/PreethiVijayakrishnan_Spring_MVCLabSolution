package com.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity class, where we define primaryKey and columns for Student Table
@Entity
@Table(name = "Student_Table")
public class Student {

	@Id
	@Column(name = "studentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;

	@Column(name = "firstName", length = 512)
	private String firstName;
	@Column(name = "lastName", length = 512)
	private String lastName;

	@Column(name = "courseName", length = 512)
	private String courseName;

	@Column(name = "country", length = 512)
	private String country;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String courseName, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseName = courseName;
		this.country = country;
	}

	public long getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", courseName=" + courseName + ", country=" + country + "]";
	}

}
