// package name
package com.student.project;

// imports hibernate utilities
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;

// GradesCall method extending driver class
public class GradesCall extends Driver{
	static Scanner reader = new Scanner(System.in);
	Transaction txn = session.beginTransaction();
	@SuppressWarnings("rawtypes")
	// stores grade database in the list
	List grade = session.createQuery("From Grades").list();

	// grades method
	public static void Grades(){
		
		int choice = 0;
		while(choice!=3){
		// welcome message
		System.out.println("Welcome to Grades Database");
		System.out.println("Press 1 to add a Grade information");
		System.out.println("Press 2 to update Grade database");
		System.out.println("Press 3 to exit");
	
		// asks for user choice
		System.out.println("Enter your choice :");
		choice = reader.nextInt();
	
			// switch-case statements
			switch(choice){
			case 1: addGrade(); // adding grades
					break;
			case 2: removeGrade(); // updating grades
					break;
			default: break; // default case
			}
		}
	}
	
	// adds grades
	public static void addGrade(){
		
		 System.out.println("Adding a Grade");
		 Grades grade = new Grades();
		 System.out.println("Enter Grade ID");
		 int idGrade = reader.nextInt();
		 System.out.println("Enter Grade A/B/C/D");
		 String gradeDist = reader.next();
		 System.out.println("Enter Required Marks");
		 int marksRequired = reader.nextInt();
		 
		 // sets the grades data 
		 grade.setGradesDistribution(gradeDist);
		 grade.setIdgrades(idGrade);
		 grade.setRequiredMarks(marksRequired);
		 
		 // saves the grade in the database 
		 session.save(grade);
	}
	
	// updates the grades
	public static void removeGrade(){
		// asks for the user choice
		System.out.println("Please Enter the Grade id to delete");
		System.out.println("Position starts from 0");
		int position = reader.nextInt();
		
		// loading grades session
		Grades grades = session.load(Grades.class,position);
		
		// deletes the grades
		session.delete(grades);
		session.flush();
	}
}