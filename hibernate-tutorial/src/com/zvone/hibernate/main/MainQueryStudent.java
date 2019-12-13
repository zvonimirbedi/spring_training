package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.BeanStudent;


public class MainQueryStudent {

	public static void main(String[] args) {
		String lastName;
		String firstName;
		String email;
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(BeanStudent.class)
								.buildSessionFactory();
		System.out.println("ZVONE: Factory created!" );
		
				
		// create session
		Session session = factory.getCurrentSession();	
		System.out.println("ZVONE: Session created!" );
		
		try {	
			
			// Begin session transaction
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );
			
			// Query students
			List<BeanStudent> theStudents = session.createQuery("from BeanStudent").list();
			
			// Display students			
			displayStudents(theStudents);
			
			// Query students lastName='Peric'
			
			lastName="Peric"; 	
			theStudents = session.createQuery("from BeanStudent where lastName='"+ lastName +"'").list();

			// Display students			
			displayStudents(theStudents);
			
			
			// Query by lastName OR firstName
			lastName="Peric";
			firstName="Jozo";
			theStudents = session.createQuery("from BeanStudent sAlias where sAlias.lastName='" + lastName +"' OR sAlias.firstName='" + firstName + "'").getResultList();
			
			// Display students			
			displayStudents(theStudents);
			
			
			// Query by email like 'gmail.com'
			
			email = "gmail.com";
			theStudents = session.createQuery("from BeanStudent sAlias where sAlias.email LIKE '%" + email + "'").getResultList();
			
			// Display students			
			displayStudents(theStudents);
			
			
			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session (object student bean)! " + new Timestamp(new Date().getTime()) );		
			}
		finally {
			//close session
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

	private static void displayStudents(List<BeanStudent> theStudents) {
		// Display students			
		for (BeanStudent iStudent : theStudents) {
		System.out.println("ZVONE: Loop Students: " +iStudent);
		}
		System.out.println("\n");
	}	
}
