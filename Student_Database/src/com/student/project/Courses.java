// package name
package com.student.project;
// Generated Mar 25, 2016 2:00:16 AM by Hibernate Tools 4.3.1.Final

// import hibernate utilities
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Courses generated by hbm2java
 */

// Courses class
@SuppressWarnings("serial")
@Entity
@Table(name = "courses", catalog = "student_database")
public class Courses implements java.io.Serializable {
	// decalaration of variables
	private int idCourses;
	private String courseName;
	private String courseTeacher;
	private String department;

	// constructor
	public Courses() {
	}
	
	// initializes the values
	public Courses(int idCourses, String courseName, String courseTeacher, String department) {
		this.idCourses = idCourses;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.department = department;
	}

	// gets courses id
	@Id
	@Column(name = "idCourses", unique = true, nullable = false)
	public int getIdCourses() {
		return this.idCourses;
	}

	// sets courses id
	public void setIdCourses(int idCourses) {
		this.idCourses = idCourses;
	}

	// gets course name
	@Column(name = "Course_Name", nullable = false, length = 45)
	public String getCourseName() {
		return this.courseName;
	}

	// sets course name
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	// gets teacher name
	@Column(name = "Course_Teacher", nullable = false, length = 45)
	public String getCourseTeacher() {
		return this.courseTeacher;
	}

	// sets teacher name
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	// gets department name
	@Column(name = "Department", nullable = false, length = 45)
	public String getDepartment() {
		return this.department;
	}

	// sets department name
	public void setDepartment(String department) {
		this.department = department;
	}
}
