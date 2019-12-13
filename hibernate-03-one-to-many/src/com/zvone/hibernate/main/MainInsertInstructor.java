package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.entities.EntityCourse;
import com.zvone.hibernate.entities.EntityInstructor;
import com.zvone.hibernate.entities.EntityInstructorDetails;


public class MainInsertInstructor {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(EntityInstructor.class)
								.addAnnotatedClass(EntityInstructorDetails.class)
								.addAnnotatedClass(EntityCourse.class)
								.buildSessionFactory();
		System.out.println("ZVONE: Factory created!" );
		
		// create session
		Session session = factory.getCurrentSession();	
		System.out.println("ZVONE: Session created!" );
		

	
		
		try { 
			
			EntityInstructor theInstructor = new EntityInstructor("Marko","Markic","markomarkic2@gmail.com");
			EntityInstructorDetails theInstructorDetail = new EntityInstructorDetails("www.youtube.com/markomarkicvlog","Pr0 Gamer");
			
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );

			session.save(theInstructor);
			System.out.println("ZVONE: Save Insttructor transaction! " + theInstructor );
			
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
