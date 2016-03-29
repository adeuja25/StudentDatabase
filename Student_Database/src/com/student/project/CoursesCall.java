
// package name
package com.student.project;

// imports hibernate utilities
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;

// CourseCall method
public class CoursesCall extends Driver{
	static Scanner reader = new Scanner(System.in);
	Transaction txn = session.beginTransaction();
	@SuppressWarnings("rawtypes")
	// storing database in the list
	List courses = session.createQuery("From Courses").list();
	
	// courses method
	public static void Courses(){
		int choice = 0;
		while(choice!=3){
		System.out.println("Welcome to Course Database");
		System.out.println("Press 1 to add a Course information");
		System.out.println("Press 2 to update Course database");
		System.out.println("Press 3 to exit");
		System.out.println("Enter your choice :");
		choice = reader.nextInt();
		
			// switch cases
			switch(choice){
			case 1: addCourses();
					break;
			case 2: removeCourses();
					break;	
			default: break;
			}
		}
	}
	
	// method to add course data in the database
	public static void addCourses(){
		 System.out.println("Adding a Course");
		 Courses course = new Courses();
		 System.out.println("Enter Course ID");
		 int idCourses = reader.nextInt();
		 System.out.println("Enter Course Name");
		 String courseName = reader.next();
		 System.out.println("Enter Course Teacher");
		 String courseTeacher = reader.next();
		 System.out.println("Enter Course Department");
		 String courseDept = reader.next();
		 
		 // sets the new data in the database
		 course.setCourseName(courseName);
		 course.setCourseTeacher(courseTeacher);
		 course.setDepartment(courseDept);
		 course.setIdCourses(idCourses);
		 
		 // saves the data in the database
		 session.save(course);
	}
	
	// updates the courses database
	public static void removeCourses(){
		System.out.println("Please Enter the course id to delete");
		System.out.println("Position starts from 0");
		int position = reader.nextInt();
		Courses courses = session.load(Courses.class, position);
		
		// deleting from databse
		session.delete(courses);
		session.flush();
	}
}
