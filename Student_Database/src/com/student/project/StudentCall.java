package com.student.project;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;

public class StudentCall extends Driver{
	static Scanner reader = new Scanner(System.in);
	Transaction txn = session.beginTransaction();
	@SuppressWarnings("rawtypes")
	List students = session.createQuery("From Student").list();

	public static void Student(){
		int choice=0;
		while(choice!=3){
		// welcome message
		System.out.println("Welcome to Student Database");
		System.out.println("Press 1 to add a student");
		System.out.println("Press 2 to remove a student");
		System.out.println("Press 3 to exit");
	
		System.out.println("Enter your choice :");
		choice = reader.nextInt();
		
			// switch - case statements
			switch(choice){
			case 1: addStudent(); // adding student
					break;
			case 2: removeStudent(); // updating student
					break;	
			default: break; // default case
			}
		}
	}
	
	// method to add student
	public static void addStudent(){
		 // get user input
		 System.out.println("Adding a student");
		 Student stu = new Student();
		 System.out.println("Enter Student ID");
		 int idstudent = reader.nextInt();
		 System.out.println("Enter First Name");
		 String firstName = reader.next();
		 System.out.println("Enter Last Name");
		 String lastName = reader.next();
		 System.out.println("Enter Age");
		 int age = reader.nextInt();
		 System.out.println("Enter Major");
		 String major = reader.next();
		 
		 // sets the student data
		 stu.setIdstudent(idstudent);
		 stu.setFirstName(firstName);
		 stu.setLastName(lastName);
		 stu.setAge(age);
		 stu.setMajor(major);
		 
		 // saves the data in the database
		 session.save(stu);
	}
	
	// method to update students
	public static void removeStudent(){
		System.out.println("Please Enter the number of the column to delete");
		System.out.println("Position starts from 0");
		int position = reader.nextInt();
		
		// load session student
		Student stud = session.load(Student.class, position);
		
		// deletes the student session
		session.delete(stud);
		session.flush();
	}
}