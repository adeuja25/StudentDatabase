// importing package
package com.student.project;

// importing java utilities
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;

// extending Driver class 
public class ClassroomCall extends Driver{
	static Scanner reader = new Scanner(System.in);
	Transaction txn = session.beginTransaction();
	@SuppressWarnings("rawtypes")
	List classroom = session.createQuery("From Classroom").list();

	// classroom method
	public static void Classroom(){
		
		int choice = 0;
		while(choice!=3){
		System.out.println("Welcome to Classroom Database");
		System.out.println("Press 1 to add a classroom information");
		System.out.println("Press 2 to update classroom database");
		System.out.println("Press 3 to exit");
		
		// getting user choice
		System.out.println("Enter your choice :");
		choice = reader.nextInt();
		
			switch(choice){
			case 1: addClassroom(); // adding data
					break;
			case 2: removeClassroom(); // updating data
					break;	
			default: break; // default case
			}
		}
	}
	// method to add data into classroom database
	public static void addClassroom(){
		 System.out.println("Adding a Classroom");
		 Classroom classes = new Classroom();
		 System.out.println("Enter Classroom ID");
		 int idClassroom = reader.nextInt();
		 System.out.println("Enter Classroom Number");
		 int classNumber = reader.nextInt();
		 System.out.println("Enter Classroom Floor");
		 int classFloor = reader.nextInt();
		 System.out.println("Enter Classroom Capacity");
		 int classCapacity = reader.nextInt();
		 System.out.println("Enter Department");
		 String classDept = reader.next();
		 
		 // setting the values
		 classes.setCapacity(classCapacity);
		 classes.setDepartment(classDept);
		 classes.setFloor(classFloor);
		 classes.setIdclassroom(idClassroom);
		 classes.setRoomNumber(classNumber);
		 
		 // saves the data in the database
		 session.save(classes);
	}
	
	// method to update the classroom data
	public static void removeClassroom(){
		System.out.println("Please Enter the Classroom id to delete");
		System.out.println("Position starts from 0");
		int position = reader.nextInt();
		Classroom cla = session.load(Classroom.class, position);
		// deletes the selected record
		session.delete(cla);
		// synchronizes the persistent store
		session.flush();
	}
}

