package com.zvone.hibernate.employees.main;

import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zvone.hibernate.BeanStudent;
import com.zvone.hibernate.employees.beans.BeanEmployees;

public class MainEmployees {

	public static void main(String[] args) {

		// System.out.println("ZVONE: ");

		System.out.println("ZVONE: Factory creation...");
		// create session factory
		SessionFactory theFactory = new Configuration().configure("hibernate.cfg.employees.xml")
				.addAnnotatedClass(BeanEmployees.class).buildSessionFactory();
		System.out.println("ZVONE: Factory creation done!");

		// create session
		System.out.println("ZVONE: Session creation...");
		Session theSession = theFactory.getCurrentSession();
		System.out.println("ZVONE: Session creation done!");

		try {

			String firstName, lastName, company;
			firstName = "Ivek";
			lastName = "Ivanovic";
			company = "ZET";
			// business logic

			System.out.println("ZVONE: BeanEmployees creation...");
			BeanEmployees theEmployee = new BeanEmployees(firstName, lastName, company);
			System.out.println("ZVONE: BeanEmployees creation done!");

			// start transaction
			System.out.println("ZVONE: transaction creation...");
			theSession.beginTransaction();
			System.out.println("ZVONE: transaction done!");

			// save object to database
			System.out.println("ZVONE: object saving...");
			theSession.save(theEmployee);
			System.out.println("ZVONE: object saved!");

			// commit the transaction
			System.out.println("ZVONE: transaction committing...");
			theSession.getTransaction().commit();
			System.out.println("ZVONE: transaction commit done!");

			// create session
			System.out.println("ZVONE: Session creation...");
			theSession = theFactory.getCurrentSession();
			System.out.println("ZVONE: Session creation done!");
			
			// start transaction
			System.out.println("ZVONE: transaction creation...");
			theSession.beginTransaction();
			System.out.println("ZVONE: transaction done!");

			System.out.println("ZVONE: BeanEmployees getting by PK...");
			theEmployee = theSession.get(BeanEmployees.class, 3);
			System.out.println("ZVONE: BeanEmployees getting by PK done!");

			System.out.println("ZVONE: Print session ID (object student bean)! " + theEmployee.getFirstName() + " "
					+ new Timestamp(new Date().getTime()));
			
			// Query employees
			company = "HEP";
			System.out.println("ZVONE: BeanEmployees getting by Query...");
			List<BeanEmployees> theEmployeeList = theSession.createQuery("from BeanEmployees where company ='" + company + "'").list();
			System.out.println("ZVONE: BeanEmployees getting by Query done!");

			for(BeanEmployees iEmployee : theEmployeeList) {
				System.out.println("ZVONE: " + company + " company, Employee: " + iEmployee);
				
			}
			
			//delete employee with
			theSession.createQuery("delete from BeanEmployees where id=20").executeUpdate();
			//or with
			//theSession.delete(theEmployee);
			
			// commit the transaction
			System.out.println("ZVONE: transaction committing...");
			theSession.getTransaction().commit();
			System.out.println("ZVONE: transaction commit done!");

		}

		finally {
			// close session
			System.out.println("ZVONE: Session closing...");
			theSession.close();
			System.out.println("ZVONE: Session closing done!");

		}

	}
}
