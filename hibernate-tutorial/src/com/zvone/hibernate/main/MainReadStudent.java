package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.BeanStudent;


public class MainReadStudent {

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
			BeanStudent studentObject = new BeanStudent("Lucko", "Luckic", "luckoluckic@gmail.com");	 
			System.out.println("ZVONE: BeanStudent object created! " + new Timestamp(new Date().getTime()) );		
			
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );

			session.save(studentObject);
			System.out.println("ZVONE: Save session (object student bean)! " + new Timestamp(new Date().getTime()) );	
			System.out.println("ZVONE: Print session (object student bean)! " + studentObject + " " +new Timestamp(new Date().getTime()) );		

			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session (object student bean)! " + new Timestamp(new Date().getTime()) );		
			
			//new get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: pk
			// find out student id PK
			System.out.println("ZVONE: Print session ID (object student bean)! " + studentObject.getId() + " " +new Timestamp(new Date().getTime()) );
			
			BeanStudent student = session.get(BeanStudent.class, studentObject.getId());
			

			System.out.println("ZVONE: Print session ID (object student bean)! " + student + " " +new Timestamp(new Date().getTime()) );
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session (object student bean)! " + new Timestamp(new Date().getTime()) );		
			
			
			
			}
		finally {
			//close session
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

}
