package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.entities.EntityInstructor;
import com.zvone.hibernate.entities.EntityInstructorDetails;


public class MainByDetailDelete {

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

			int theId = 5;
			EntityInstructorDetails instructorDetail = session.get(EntityInstructorDetails.class, theId);
			System.out.println("ZVONE: Instructor details retrieved " + instructorDetail);		
			

			System.out.println("ZVONE: Instructor retrieved from previous Instructor details" + instructorDetail.getTheInstructor());		
			
			// remove the link: break bi direct ref
			instructorDetail.getTheInstructor().setInstructorDetail(null);			
			
			// delete instructor detail + instructor
			System.out.println("ZVONE: Instructor details delete " + instructorDetail);
			session.delete(instructorDetail);
			
			
			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session! " + new Timestamp(new Date().getTime()) );		
			}
		catch(Exception exc){
			exc.printStackTrace();			
		}
		finally {
			//close session
			session.close();
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

}
