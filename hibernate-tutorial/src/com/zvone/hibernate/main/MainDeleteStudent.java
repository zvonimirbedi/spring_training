package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.BeanStudent;


public class MainDeleteStudent {

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
			
			//BeanStudent student = session.get(BeanStudent.class, studentID);
			
			//System.out.println("ZVONE: Print Read Object student bean by ID: " + student + " " +new Timestamp(new Date().getTime()) );
			
			// Delete the row by id
			
			//session.delete(student);
			
			//System.out.println("ZVONE: Print Deleted Object student bean by ID: " + student + " " +new Timestamp(new Date().getTime()) );
			
			
			session.createQuery("delete from BeanStudent where id=2").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session:  " + new Timestamp(new Date().getTime()) );		
			
			}
		finally {
			//close session
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

}
