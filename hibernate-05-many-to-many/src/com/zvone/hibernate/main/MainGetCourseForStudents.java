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
import com.zvone.hibernate.entities.EntityStudent;


public class MainGetCourseForStudents {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(EntityInstructor.class)
								.addAnnotatedClass(EntityInstructorDetails.class)
								.addAnnotatedClass(EntityCourse.class)
								.addAnnotatedClass(EntityReview.class)
								.addAnnotatedClass(EntityStudent.class)
								.buildSessionFactory();
		System.out.println("ZVONE: Factory created!" );
		
		// create session
		Session session = factory.getCurrentSession();	
		System.out.println("ZVONE: Session created!" );
		

	
		
		try { 
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );

			int studentId = 4;
			EntityStudent theStudent1 = session.get(EntityStudent.class, studentId);	

			System.out.println("ZVONE: Student: " + theStudent1 );		
			System.out.println("ZVONE: Student: " + theStudent1.getCourses() );			

								
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
