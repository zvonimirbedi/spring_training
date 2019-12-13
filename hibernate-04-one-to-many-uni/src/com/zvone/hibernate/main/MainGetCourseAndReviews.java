package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zvone.hibernate.entities.EntityCourse;
import com.zvone.hibernate.entities.EntityInstructor;
import com.zvone.hibernate.entities.EntityInstructorDetails;
import com.zvone.hibernate.entities.EntityReview;


public class MainGetCourseAndReviews {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(EntityInstructor.class)
								.addAnnotatedClass(EntityInstructorDetails.class)
								.addAnnotatedClass(EntityCourse.class)
								.addAnnotatedClass(EntityReview.class)
								.buildSessionFactory();
		System.out.println("ZVONE: Factory created!" );
		
		// create session
		Session session = factory.getCurrentSession();	
		System.out.println("ZVONE: Session created!" );
		

	
		
		try { 
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );

			int theId = 19;
			EntityCourse theCourse = session.get(EntityCourse.class, theId);
			System.out.println("ZVONE: Course: " + theCourse );		
			System.out.println("ZVONE: Course Reviews: " + theCourse.getReviews() );		
			
			
			
			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session " + new Timestamp(new Date().getTime()) );		
			}
		finally {
			//close session
			session.close();
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

}
