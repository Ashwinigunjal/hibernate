package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hibernet.demo.saveData;

class CheckConnection {

	public static void main(String[] args) throws Exception {
	
		String url="jdbc:mysql://localhost:3306/Student";
		System.out.println("cpnnecting to database");
		try {
			Connection conn=DriverManager.getConnection(url,"root","root");
			System.out.println("connection successful");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		saveData.setUp();
	} 
	
}
