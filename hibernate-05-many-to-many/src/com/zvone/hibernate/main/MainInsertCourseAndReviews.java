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


public class MainInsertCourseAndReviews {

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

			EntityCourse theCourse = new EntityCourse("C#");
			EntityReview theReview1 = new EntityReview("C# course was great!");
			EntityReview theReview2 = new EntityReview("C# course was amazing!");
			EntityReview theReview3 = new EntityReview("C# course was the best!");
			
			theCourse.addReview(theReview1);
			theCourse.addReview(theReview2);
			theCourse.addReview(theReview3);

			System.out.println("ZVONE: Saving course and reviews..." );		
			System.out.println("ZVONE: Course" + theCourse );		
			System.out.println("ZVONE: Course" + theCourse.getReviews() );		
			
			session.save(theCourse);
			
			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session (object student bean)! " + new Timestamp(new Date().getTime()) );		
			}
		finally {
			//close session
			session.close();
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

}
