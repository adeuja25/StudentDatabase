package com.student.project;

// importing java languages
import java.io.File;
import java.util.Scanner;

// importing hibernate session, transaction and configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Driver class
public class Driver {
	// getting the location of the hibernate configuration file
	static File file = new File("C://Users//Snoop//workspace//Student_Database//src//hibernate.cfg.xml");
	
	// creating sessionFactory
	static SessionFactory sFactory = new Configuration().configure(file).buildSessionFactory();

	// opening session
	static Session session = sFactory.openSession();
	
	// main method
	public static void main(String[] args) {
		
		// begin transaction
		Transaction txn = session.beginTransaction();
		
		// welcome method to welcome the user
		welcome();
		
		// commit the changes
		txn.commit();
		
		// closing the session
		session.close();

		// Print Good Bye message
		System.out.println("Good Bye!");
		
	}
	
	// welcome method
	public static void welcome(){
		int choice =0;
		while(choice!=6){
		System.out.println("Welcome to Database");
		System.out.println("Press 1 to enter Student Database");
		System.out.println("Press 2 to enter Courses Database");
		System.out.println("Press 3 to enter Library Database");
		System.out.println("Press 4 to enter Grades Database");
		System.out.println("Press 5 to enter Classroom Database");
		System.out.println("Press 6 to exit");
		
		
		// getting user choice 
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter your choice :");
		choice = reader.nextInt();
				
		switch(choice){
		case 1 :StudentCall.Student(); // calls student class
				break;
		case 2 :CoursesCall.Courses(); // calls courses class
				break;
		case 3 :LibraryCall.Library(); // calls library class
				break;
		case 4 :GradesCall.Grades();   // calls grades class 
				break;
		case 5 :ClassroomCall.Classroom(); // calls classroom class
				break;
		default:break; // default break
		}
		}
		
		
	}
	

}
 