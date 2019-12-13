package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.entities.EntityInstructor;
import com.zvone.hibernate.entities.EntityInstructorDetails;


public class MainDelete {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(EntityInstructor.class)
								.addAnnotatedClass(EntityInstructorDetails.class)
								.buildSessionFactory();
		System.out.println("ZVONE: Factory created!" );
		
		// create session
		Session session = factory.getCurrentSession();	
		System.out.println("ZVONE: Session created!" );
		

	
		
		try { 
			//create the objects 
			/*
			EntityInstructor instructor = new EntityInstructor("Zvone", "Bedi", "frajer123@gmail.com");		
			EntityInstructorDetails instructorDetails = new EntityInstructorDetails("www.youtube.com/zvone", "Frajer programiras badava");
			*/
			
			EntityInstructor instructor = new EntityInstructor("Ivo", "Ivic", "ivoivic@gmail.com");		
			EntityInstructorDetails instructorDetails = new EntityInstructorDetails("www.youtube.com/ivoivic", "Frajer programira 100eura na sat");

			// link objects (tables)
			instructor.setInstructorDetail(instructorDetails);
						
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );

			 //save the instructor
			System.out.println("ZVONE: Save sessino "+instructor);
			session.save(instructor);
			
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
