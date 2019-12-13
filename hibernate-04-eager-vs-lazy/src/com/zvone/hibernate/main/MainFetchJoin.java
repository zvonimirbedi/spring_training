package com.zvone.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.zvone.hibernate.entities.EntityCourse;
import com.zvone.hibernate.entities.EntityInstructor;
import com.zvone.hibernate.entities.EntityInstructorDetails;


public class MainFetchJoin {

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
			session.beginTransaction();
			System.out.println("ZVONE: Begin session transaction! " + new Timestamp(new Date().getTime()) );
			
			// hibernate query HQL

			int theId = 1;

			Query<EntityCourse> query = session.createQuery("Select i from EntityCourse i "
					+"where i.instructor.id=:theInstructorId"
					, EntityCourse.class);
			
			query.setParameter("theInstructorId", theId);
			
			EntityCourse theCourses = query.getSingleResult();
			
			System.out.println("ZVONE: Instructor: "+ theCourses );	
			

			session.getTransaction().commit();
			System.out.println("ZVONE: Commit session! " + new Timestamp(new Date().getTime()) );


			session.close();			
			System.out.println("ZVONE: Instructor Courses: "+ theCourses );		

			}
		finally {
			//close session
			session.close();
			factory.close();
			System.out.println("ZVONE: Factory closed!" );
		}
		

	}

}
