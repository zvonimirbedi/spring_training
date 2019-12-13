package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.BeanStudent;


public class MainUpdateStudent {

	public static void main(String[] args) {
		
		
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
			
			int studentID= 1;
			
			//new get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("ZVONE: Print session ID: " + studentID + " " +new Timestamp(new Date().getTime()) );
			
			BeanStudent student = session.get(BeanStudent.class, studentID);
			
			System.out.println("ZVONE: Print Read Object student bean by ID: " + student + " " +new Timestamp(new Date().getTime()) );
			
			student.setFirstName("Perica");
			
			System.out.println("ZVONE: Print Updated Object student bean by ID: " + student + " " +new Timestamp(new Date().getTime()) );
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session:  " + new Timestamp(new Date().getTime()) );		
			
			
			//new get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update BeanStudent set email='test@net.hr'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			}
		finally {
			//close session
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

}
