package com.zvone.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainTestJDBC {

	public static void main(String[] args) {
		
		String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String jdbcuser = "hbstudent";
		String jdbcpassword = "hbstudent";

		System.out.println("ZVONE: Connecting to database: "+ jdbcurl);
		
		try {
			Connection jdbcConnection = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);

			System.out.println("ZVONE: Connecting successful!" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ZVONE: Connecting failed!" );
			e.printStackTrace();
		}

	}

}
