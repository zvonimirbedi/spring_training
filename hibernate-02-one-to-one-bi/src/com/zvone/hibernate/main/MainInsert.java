package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.entities.EntityInstructor;
import com.zvone.hibernate.entities.EntityInstructorDetails;


public class MainInsert {

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
			
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );

			// get instructor by PK
			int theId = 3;
			
			EntityInstructor instructor = session.get(EntityInstructor.class, theId);
			System.out.println("ZVONE: Found instructor "+ instructor);
						
			// delete instructor by PK
			if (instructor != null) {
				System.out.println("ZVONE: Deleting "+instructor);
				session.delete(instructor);
				
			}
			
			
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
