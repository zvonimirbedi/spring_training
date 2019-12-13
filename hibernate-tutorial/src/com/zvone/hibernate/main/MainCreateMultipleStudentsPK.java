package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.BeanStudent;

public class MainCreateMultipleStudentsPK {

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
			BeanStudent studentObject1 = new BeanStudent("Pero", "Peric", "peroperic@outlook.com");	
			BeanStudent studentObject2 = new BeanStudent("Marko", "Markic", "markomarkic@outlook.com");	
			BeanStudent studentObject3 = new BeanStudent("Jozo", "Jozic", "jozojozic@outlook.com");	 
			System.out.println("ZVONE: BeanStudent object created! " + new Timestamp(new Date().getTime()) );		
			
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );

			session.save(studentObject1);
			session.save(studentObject2);
			session.save(studentObject3);
			System.out.println("ZVONE: Save session (object student bean)! " + new Timestamp(new Date().getTime()) );		

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
