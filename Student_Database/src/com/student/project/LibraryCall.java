// package name
package com.student.project;

// imports hibernate utilities
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;

// LibraryCall method
public class LibraryCall extends Driver{
	static Scanner reader = new Scanner(System.in);
	Transaction txn = session.beginTransaction();
	
	// stores the classroom database in the list
	@SuppressWarnings("rawtypes")
	List classroom = session.createQuery("From Library").list();

	// Library method 
	public static void Library(){
		
		int choice= 0;
		while(choice!=3){
		// welcome messages
		System.out.println("Welcome to Library Database");
		System.out.println("Press 1 to add a Book information");
		System.out.println("Press 2 to update Library database");
		System.out.println("Press 3 to exit");
		
		// asks for user choice
		System.out.println("Enter your choice :");
		choice = reader.nextInt();
		
			// switch - case statements
			switch(choice){
			case 1: addLibrary();	// adding data in the database
					break;
			case 2: removeLibrary();// updating the database
					break;	
			default: break; // default case
			}
		}
	}
	
	// adds data in the database
	public static void addLibrary(){
		 
		 System.out.println("Adding a book");
		 Library library = new Library();
		 System.out.println("Enter Library ID");
		 int idLibrary = reader.nextInt();
		 System.out.println("Enter Book Name");
		 String bookName = reader.next();
		 System.out.println("Enter Return Days");
		 int returnDays = reader.nextInt();
		 System.out.println("Enter Major");
		 String major = reader.next();
		 
		 // sets the data
		 library.setBooks(bookName);
		 library.setIdlibrary(idLibrary);
		 library.setMajor(major);
		 library.setReturnDays(returnDays);
		 
		 // saves the data in the database
		 session.save(library);
	}
	
	// updates the databse
	public static void removeLibrary(){
		System.out.println("Please Enter the Library id to delete");
		System.out.println("Position starts from 0");
		int position = reader.nextInt();
		Library lib = session.load(Library.class, position);
		
		// deletes the row
		session.delete(lib);
		session.flush();
	}
}

